package com.example.sudoku_v1

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sudoku_v1.databinding.ActivitySettingsBinding

class Settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        buttonController(binding)
    }
    private fun buttonController(binding: ActivitySettingsBinding) {
        binding.backSettings.setBackgroundColor(Color.LTGRAY)
        binding.chooseTheme1.setBackgroundColor(Color.GREEN)
        binding.chooseTheme2.setBackgroundColor(Color.LTGRAY)
        binding.chooseTheme3.setBackgroundColor(Color.LTGRAY)
        binding.backSettings.setOnClickListener() {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        binding.chooseTheme1.setOnClickListener() {
            style = 0;
            binding.chooseTheme1.setBackgroundColor(Color.GREEN)
            binding.chooseTheme2.setBackgroundColor(Color.LTGRAY)
            binding.chooseTheme3.setBackgroundColor(Color.LTGRAY)
        }
        binding.chooseTheme2.setOnClickListener() {
            style = 1;
            binding.chooseTheme1.setBackgroundColor(Color.LTGRAY)
            binding.chooseTheme2.setBackgroundColor(Color.GREEN)
            binding.chooseTheme3.setBackgroundColor(Color.LTGRAY)
        }
        binding.chooseTheme3.setOnClickListener() {
            style = 2;
            binding.chooseTheme1.setBackgroundColor(Color.LTGRAY)
            binding.chooseTheme2.setBackgroundColor(Color.LTGRAY)
            binding.chooseTheme3.setBackgroundColor(Color.GREEN)
        }
    }
}