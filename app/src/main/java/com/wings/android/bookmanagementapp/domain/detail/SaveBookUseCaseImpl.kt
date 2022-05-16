package com.wings.android.bookmanagementapp.domain.detail

import com.wings.android.bookmanagementapp.data.repository.LocalBookRepository
import com.wings.android.bookmanagementapp.util.Signal
import com.wings.android.bookmanagementapp.view.model.Book
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

class SaveBookUseCaseImpl @Inject constructor(
    private val repository: LocalBookRepository,
    private val isAlreadySavedUseCase: IsAlreadySavedUseCase
) : SaveBookUseCase {
    @OptIn(ExperimentalCoroutinesApi::class)
    override fun invoke(new: Book): Flow<Signal> {
        return isAlreadySavedUseCase(new.isbn)
            .flatMapLatest { isAlreadySaved ->
                if (isAlreadySaved) repository.updateBook(new)
                else repository.initializeBook(new)
            }
    }
}
