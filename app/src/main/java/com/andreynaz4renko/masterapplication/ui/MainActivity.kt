package com.andreynaz4renko.masterapplication.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.andreynaz4renko.masterapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.counter.observe(this) { counter ->
            binding.counterView.text = counter.toString()
        }

        binding.minusButton.setOnClickListener {
            viewModel.decreaseCounter()
        }

        binding.plusButton.setOnClickListener {
            viewModel.increaseCounter()
        }

    }
}