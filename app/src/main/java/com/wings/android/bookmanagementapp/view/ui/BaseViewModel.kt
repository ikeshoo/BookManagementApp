package com.wings.android.bookmanagementapp.view.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

abstract class BaseViewModel() : ViewModel() {

    private val _loading = MutableStateFlow<Loading?>(null)
    val loading: StateFlow<Loading?>
        get() = _loading

    private val _failure = MutableStateFlow<Failure?>(null)
    val failure: StateFlow<Failure?>
        get() = _failure

    fun <T> Flow<T>.execute(
        onSuccess: ((T) -> Unit) = {},
        retry: () -> Unit
    ) {
        viewModelScope.launch {
            flowOn(Dispatchers.IO)
                .onStart { _loading.value = Loading(isLoading = true) }
                .onCompletion { _loading.value = Loading(isLoading = false) }
                .catch {
                    _failure.value = Failure(error = it, retry = retry)
                }
                .collect { onSuccess(it) }
        }
    }
}

data class Loading(
    val isLoading: Boolean = false
)

data class Failure(
    val error: Throwable,
    val retry: () -> Unit
)
