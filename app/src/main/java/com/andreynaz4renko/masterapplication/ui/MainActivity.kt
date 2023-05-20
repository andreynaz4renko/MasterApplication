package com.andreynaz4renko.masterapplication.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.andreynaz4renko.masterapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.minusButton.setOnClickListener {

        }

        binding.plusButton.setOnClickListener {

        }

    }
}