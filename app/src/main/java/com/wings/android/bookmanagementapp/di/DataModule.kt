package com.wings.android.bookmanagementapp.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.wings.android.bookmanagementapp.data.source.local.PreferenceLocal
import com.wings.android.bookmanagementapp.data.source.local.PreferenceLocalImpl
import com.wings.android.bookmanagementapp.data.source.remote.RaktenApi
import com.wings.android.bookmanagementapp.util.BookListSerializer
import com.wings.android.bookmanagementapp.view.model.BookList
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

    // DataStoreの設定
    private const val JSON_FILE = "book_list.json"
    private val Context.bookDataStore: DataStore<BookList> by dataStore(
        fileName = JSON_FILE,
        serializer = BookListSerializer
    )

    @Singleton
    @Provides
    fun provideDataStore(@ApplicationContext context: Context): DataStore<BookList> {
        return context.bookDataStore
    }

    @Singleton
    @Provides
    fun providePreferenceLocal(dataStore: DataStore<BookList>): PreferenceLocal {
        return PreferenceLocalImpl(dataStore)
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
