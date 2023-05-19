package com.andreynaz4renko.masterapplication.data

import retrofit2.Response
import retrofit2.http.GET

interface ProfileApi {

    @GET("user/1")
    suspend fun getUsers(): Response<UserResponseData>

}