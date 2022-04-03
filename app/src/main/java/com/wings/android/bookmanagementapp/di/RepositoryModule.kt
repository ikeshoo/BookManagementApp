package com.wings.android.bookmanagementapp.di

import com.wings.android.bookmanagementapp.data.repository.LocalBookListRepository
import com.wings.android.bookmanagementapp.data.repository.LocalBookListRepositoryImpl
import com.wings.android.bookmanagementapp.data.repository.RankingRepository
import com.wings.android.bookmanagementapp.data.repository.RankingRepositoryImpl
import com.wings.android.bookmanagementapp.data.repository.SearchRepository
import com.wings.android.bookmanagementapp.data.repository.SearchRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindRankingRepository(
        rankingRepositoryImpl: RankingRepositoryImpl
    ): RankingRepository

    @Binds
    abstract fun bindSearchRepository(
        searchRepositoryImpl: SearchRepositoryImpl
    ): SearchRepository

    @Binds
    abstract fun bindLocalBookListRepository(
        localBookListRepositoryImpl: LocalBookListRepositoryImpl
    ): LocalBookListRepository
}
