package com.wings.android.bookmanagementapp.domain.detail

import com.wings.android.bookmanagementapp.util.Signal
import com.wings.android.bookmanagementapp.view.model.Book
import kotlinx.coroutines.flow.Flow

interface SaveBookUseCase {
    operator fun invoke(new: Book): Flow<Signal>
}
