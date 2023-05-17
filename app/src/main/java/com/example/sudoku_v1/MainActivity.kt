package com.example.sudoku_v1

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.AnimatedImageDrawable
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random
import com.example.sudoku_v1.databinding.ActivityMainBinding

public var mode: Int = 1
public var style: Int = 0
public var new: Boolean = true
public var showWrong: Boolean = false

class MainActivity : AppCompatActivity() {
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        buttonListener()
        supportActionBar?.hide()
    }

    private fun buttonListener() {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        (binding.root.background as AnimatedImageDrawable).start()
        binding.checkGame.setOnClickListener() {
            startActivity(Intent(this, SudokuImport::class.java))
            finish()
        }
        binding.continueGame.setOnClickListener() {
            new = false
            if (style == 0) {
                startActivity(Intent(this, SudokuStandart::class.java))
                finish()
            } else if (style == 1) {
                startActivity(Intent(this, SudokuSakura::class.java))
                finish()
            } else {
                startActivity(Intent(this, SudokuBlocks::class.java))
                finish()
            }
        }
        binding.newGame.setOnClickListener() {
            new = true
            if (style == 0) {
                startActivity(Intent(this, SudokuStandart::class.java))
                finish()
            } else if (style == 1) {
                startActivity(Intent(this, SudokuSakura::class.java))
                finish()
            } else {
                startActivity(Intent(this, SudokuBlocks::class.java))
                finish()
            }
        }
        binding.settings.setOnClickListener() {
            startActivity(Intent(this, Settings::class.java))
            finish()
        }
    }
}

