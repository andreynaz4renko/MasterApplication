package com.andreynaz4renko.masterapplication.ui

import android.content.Context
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.andreynaz4renko.masterapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.counter.observe(this) { counter ->
            binding.counterView.text = counter.toString()
        }

        binding.counterView.setOnClickListener {
            viewModel.clearCounter()
        }

        binding.minusButton.setOnClickListener {
            viewModel.decreaseCounter()
        }

        binding.plusButton.setOnClickListener {
            viewModel.increaseCounter()
        }

        binding.minusButton.setOnLongClickListener {
            viewModel.decreaseCounter(5)
            true
        }

        binding.plusButton.setOnLongClickListener {
            viewModel.increaseCounter(5)
            true
        }

    }

    override fun onPause() {
        super.onPause()
        viewModel.saveCounter(dataStore)
    }

    override fun onResume() {
        super.onResume()
        viewModel.refreshCounter(dataStore)
    }
}