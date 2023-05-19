package com.andreynaz4renko.masterapplication.data

class ProfileRepository(
    private val profileApi: ProfileApi
) {

    suspend fun getUsers() = profileApi.getUsers()

}