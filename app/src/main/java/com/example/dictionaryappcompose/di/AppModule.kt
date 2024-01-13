package com.example.dictionaryappcompose.di

import com.example.dictionaryappcompose.BuildConfig
import com.example.dictionaryappcompose.data.repository.DictionaryRepositoryImpl
import com.example.dictionaryappcompose.data.repository.datasources.DataSource
import com.example.dictionaryappcompose.data.repository.datasources.remote.RemoteDataSource
import com.example.dictionaryappcompose.data.repository.datasources.remote.apis.DictionaryRapidApi
import com.example.dictionaryappcompose.domain.repository.DictionaryRepository
import com.example.dictionaryappcompose.domain.useCases.getDefinitions.GetDefinitionsUseCase
import com.example.dictionaryappcompose.domain.useCases.sortDefinitions.SortDefinitionsUseCase
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    private const val BASE_URL = "https://mashape-community-urban-dictionary.p.rapidapi.com"

    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else {
        OkHttpClient
            .Builder()
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val contentType = "application/json".toMediaType()
        val json =
            Json {
                ignoreUnknownKeys = true
            }
        return Retrofit.Builder()
            .addConverterFactory(json.asConverterFactory(contentType))
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideDictionaryApi(retrofit: Retrofit): DictionaryRapidApi =
        retrofit.create(DictionaryRapidApi::class.java)

    @Provides
    @Singleton
    fun provideDictionaryRemoteDataSource(api: DictionaryRapidApi): DataSource =
        RemoteDataSource(api)

    @Provides
    @Singleton
    fun provideDictionaryRepository(remoteDataSource: RemoteDataSource): DictionaryRepository =
        DictionaryRepositoryImpl(remoteDataSource)

    @Provides
    @Singleton
    fun provideGetDefinitionsUseCase(repository: DictionaryRepository): GetDefinitionsUseCase =
        GetDefinitionsUseCase(repository)

    @Provides
    @Singleton
    fun provideSortDefinitionsUseCase(): SortDefinitionsUseCase = SortDefinitionsUseCase()
}
