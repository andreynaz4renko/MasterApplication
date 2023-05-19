package com.andreynaz4renko.masterapplication.di

import com.andreynaz4renko.masterapplication.data.ProfileApi
import com.andreynaz4renko.masterapplication.data.ProfileRepository
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


@Module
@InstallIn(SingletonComponent::class)
object ProfileModule {

    @Provides
    fun provideProfileApi(): ProfileApi {
        val logging = HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }

        val client = OkHttpClient.Builder().apply {
            addInterceptor(logging)
        }.build()

        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl("https://64677ed82ea3cae8dc30bee3.mockapi.io/")
            .addConverterFactory(Json.asConverterFactory(contentType))
            .client(client)
            .build()
            .create(ProfileApi::class.java)
    }

    @Provides
    fun provideProfileRepository(profileApi: ProfileApi) = ProfileRepository(profileApi)

}