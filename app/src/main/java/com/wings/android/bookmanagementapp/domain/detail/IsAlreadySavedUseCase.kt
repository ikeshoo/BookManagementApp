package com.wings.android.bookmanagementapp.domain.detail

import kotlinx.coroutines.flow.Flow

interface IsAlreadySavedUseCase {
    operator fun invoke(isbn: Long): Flow<Boolean>
}
