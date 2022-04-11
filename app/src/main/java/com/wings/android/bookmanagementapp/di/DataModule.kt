package com.wings.android.bookmanagementapp.di

import android.content.Context
import androidx.room.Room
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.wings.android.bookmanagementapp.data.source.local.BookDao
import com.wings.android.bookmanagementapp.data.source.local.BookDatabase
import com.wings.android.bookmanagementapp.data.source.remote.RaktenApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideBookDatabase(@ApplicationContext context: Context): BookDatabase {
        return Room.databaseBuilder(
            context,
            BookDatabase::class.java,
            "book_database"
        ).build()
    }

    @Singleton
    @Provides
    fun provideBookDao(database: BookDatabase): BookDao {
        return database.bookDao()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()
    }

    @Singleton
    @Provides
    fun provideRankingRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        val baseUrl = "https://app.rakuten.co.jp/"
        val jsonSetting = Json {
            prettyPrint = true
            ignoreUnknownKeys = true
        }

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(jsonSetting.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    @Singleton
    @Provides
    fun provideRaktenApi(
        retrofit: Retrofit
    ): RaktenApi {
        return retrofit.create(RaktenApi::class.java)
    }
}
