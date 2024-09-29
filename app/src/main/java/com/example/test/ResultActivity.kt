package com.example.test

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.test.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    // TODO 18: Add lateinit var for binding
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO 19: Bind the view and implement setContentView()
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO 20: Check the RESULT from the intent and change rlBackground BackgroundColor / btnQuit BackgroundColor / imgResult / txtResult / txtName / txtAnswer
        val result = intent.getStringExtra(RESULT) ?: FAILED
        val name = intent.getStringExtra(NAME) ?: "Anonymous"

        if (result == SUCCESS) {
            // Set success UI changes
            binding.rlBackground.setBackgroundColor(Color.GREEN)
            binding.btnQuit.setBackgroundColor(Color.GREEN)
            binding.imgResult.setImageResource(R.drawable.ic_success) // Assuming you have success image
            binding.txtResult.text = "Success!"
            binding.txtResult.setTextColor(Color.WHITE)
        } else {
            // Set failure UI changes
            binding.rlBackground.setBackgroundColor(Color.RED)
            binding.btnQuit.setBackgroundColor(Color.RED)
            binding.imgResult.setImageResource(R.drawable.ic_failure) // Assuming you have failure image
            binding.txtResult.text = "Failed!"
            binding.txtResult.setTextColor(Color.WHITE)
        }

        // Set name and result text
        binding.txtName.text = "Name: $name"
        binding.txtAnswer.text = "Your result: $result"

        // TODO 21: Implement setOnClickListener for btnQuit to destroy the activity
        binding.btnQuit.setOnClickListener {
            finish() // Closes the activity
        }
    }
}
