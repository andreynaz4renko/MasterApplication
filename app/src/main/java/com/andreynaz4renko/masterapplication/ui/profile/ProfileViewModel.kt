package com.andreynaz4renko.masterapplication.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreynaz4renko.masterapplication.data.ProfileRepository
import com.andreynaz4renko.masterapplication.data.UserResponseData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var profileRepository: ProfileRepository

    private val _profileData = MutableLiveData<UserResponseData>()
    val profileData: LiveData<UserResponseData> = _profileData

    fun getProfileData() {
        viewModelScope.launch {
            val response = profileRepository.getUsers()
            if (response.isSuccessful) {
                _profileData.value = response.body()
            }
        }
    }

}