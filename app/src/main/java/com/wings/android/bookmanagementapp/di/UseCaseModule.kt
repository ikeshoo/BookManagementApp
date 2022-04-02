package com.wings.android.bookmanagementapp.di

import com.wings.android.bookmanagementapp.domain.detail.SearchByIsbnUseCase
import com.wings.android.bookmanagementapp.domain.detail.SearchByIsbnUseCaseImpl
import com.wings.android.bookmanagementapp.domain.ranking.GetRankingListUseCase
import com.wings.android.bookmanagementapp.domain.ranking.GetRankingListUseCaseImpl
import com.wings.android.bookmanagementapp.domain.search.SearchByTitleUseCase
import com.wings.android.bookmanagementapp.domain.search.SearchByTitleUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {
    @Binds
    abstract fun bindGetRankingListUseCase(
        getRankingListUseCaseImpl: GetRankingListUseCaseImpl
    ): GetRankingListUseCase

    @Binds
    abstract fun bindSearchByTitleUseCase(
        searchByTitleUseCaseImpl: SearchByTitleUseCaseImpl
    ): SearchByTitleUseCase

    @Binds
    abstract fun bindSearchByIsbnUseCase(
        searchByIsbnUseCaseImpl: SearchByIsbnUseCaseImpl
    ): SearchByIsbnUseCase
}
