package com.andreynaz4renko.masterapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _counter = MutableLiveData(0)
    val counter: LiveData<Int> = _counter

    fun increaseCounter(value: Int = 1) {
        _counter.value = counter.value?.plus(value)
    }

    fun decreaseCounter(value: Int = 1) {
        _counter.value = counter.value?.minus(value)
    }

    fun clearCounter() {
        _counter.value = 0
    }

}