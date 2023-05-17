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
        binding.chooseTheme1.setBackgroundColor(Color.LTGRAY)
        binding.chooseTheme2.setBackgroundColor(Color.LTGRAY)
        binding.chooseTheme3.setBackgroundColor(Color.LTGRAY)
        binding.easy.setBackgroundColor(Color.LTGRAY)
        binding.middle.setBackgroundColor(Color.LTGRAY)
        binding.hard.setBackgroundColor(Color.LTGRAY)
        when (style) {
            0->binding.chooseTheme1.setBackgroundColor(Color.GREEN)
            1->binding.chooseTheme2.setBackgroundColor(Color.GREEN)
            2->binding.chooseTheme3.setBackgroundColor(Color.GREEN)
        }
        when (mode) {
            0->binding.easy.setBackgroundColor(Color.GREEN)
            1->binding.middle.setBackgroundColor(Color.GREEN)
            2->binding.hard.setBackgroundColor(Color.GREEN)
        }
        if (showWrong) {
            binding.switchShowWrong.setBackgroundColor(Color.GREEN)
        } else {
            binding.switchShowWrong.setBackgroundColor(Color.LTGRAY)
        }
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
        binding.easy.setOnClickListener() {
            mode = 0
            binding.easy.setBackgroundColor(Color.GREEN)
            binding.middle.setBackgroundColor(Color.LTGRAY)
            binding.hard.setBackgroundColor(Color.LTGRAY)
        }
        binding.middle.setOnClickListener() {
            mode = 1
            binding.easy.setBackgroundColor(Color.LTGRAY)
            binding.middle.setBackgroundColor(Color.GREEN)
            binding.hard.setBackgroundColor(Color.LTGRAY)
        }
        binding.hard.setOnClickListener() {
            mode = 2
            binding.easy.setBackgroundColor(Color.LTGRAY)
            binding.middle.setBackgroundColor(Color.LTGRAY)
            binding.hard.setBackgroundColor(Color.GREEN)
        }
        binding.switchShowWrong.setOnClickListener() {
            showWrong = !showWrong
            if (showWrong) {
                binding.switchShowWrong.setBackgroundColor(Color.GREEN)
            } else {
                binding.switchShowWrong.setBackgroundColor(Color.LTGRAY)
            }
        }
    }
}