package com.wings.android.bookmanagementapp.domain.detail

import com.wings.android.bookmanagementapp.data.repository.LocalBookListRepository
import com.wings.android.bookmanagementapp.util.Signal
import com.wings.android.bookmanagementapp.view.model.Book
import kotlinx.collections.immutable.mutate
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

class SaveBookUseCaseImpl @Inject constructor(
    private val repository: LocalBookListRepository,
    private val getBookListUseCase: GetBookListUseCase
) : SaveBookUseCase {
    @OptIn(ExperimentalCoroutinesApi::class)
    override fun invoke(new: Book): Flow<Signal> {
        return getBookListUseCase.invoke()
            .flatMapLatest { bookList ->
                val newList = bookList.copy(
                    value = bookList.value.mutate { list ->
                        list.add(0, new)
                    }
                )
                repository.saveBook(newList)
            }
    }
}