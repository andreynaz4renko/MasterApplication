package com.andreynaz4renko.masterapplication.ui

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _counter = MutableLiveData(0)
    val counter: LiveData<Int> = _counter

    private val counterPreferencesKey = intPreferencesKey("counter")

    fun increaseCounter(value: Int = 1) {
        _counter.value = counter.value?.plus(value)
    }

    fun decreaseCounter(value: Int = 1) {
        _counter.value = counter.value?.minus(value)
    }

    fun clearCounter() {
        _counter.value = 0
    }

    fun saveCounter(dataStore: DataStore<Preferences>) {
        viewModelScope.launch {
            dataStore.edit { preferences ->
                preferences[counterPreferencesKey] = _counter.value ?: 0
            }
        }
    }

    fun refreshCounter(dataStore: DataStore<Preferences>) {
        viewModelScope.launch {
            dataStore.data.collect { preferences ->
                _counter.value = preferences[counterPreferencesKey] ?: 0
            }
        }
    }

}