package com.example.sudoku_v1

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.sudoku_v1.databinding.ActivitySudokuStandartBinding

class SudokuStandart : AppCompatActivity() {

    lateinit var fullTable: Array<IntArray>
    lateinit var table: Array<IntArray>

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        val binding = ActivitySudokuStandartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val layout = findViewById<TableLayout>(R.id.tableLayout)
        val a: Int = layout.childCount
        var xCord: Int = 0
        var yCord: Int = 0
        var tmp: Int = 0;
        val sudokuGenerator = SudokuGenerator()
        var sendTextView: TextView = binding.TextView1
        fullTable = sudokuGenerator.generate()
        table = sudokuGenerator.makePartlyFilled(fullTable, 20 * (mode + 1))
        for (i in 0 until a) {
            val child: View = layout.getChildAt(i)
            if (child is TableRow) {
                for (x in 0 until child.childCount) {
                    val btn = child.getChildAt(x)
                    if (btn is TextView) {
                        tmp = table[yCord][xCord]
                        if (tmp == 0) {
                            sendTextView = btn
                            btn.setBackgroundColor(Color.LTGRAY)
                        } else {
                            btn.text = table[yCord][xCord].toString()
                            btn.setBackgroundColor(Color.GRAY)
                        }
                        xCord++
                    }
                }
                yCord++
                xCord = 0
            }
        }
        TextViewController(
            binding,
            table,
            fullTable,
            sendTextView,
            Color.LTGRAY,
            Color.DKGRAY
        ).allListener()
        binding.check.setOnClickListener() {
            var correct: Boolean = true
            xCord = 0;
            yCord = 0
            for (i in 0 until a) {
                val child: View = layout.getChildAt(i)
                if (child is TableRow) {
                    for (x in 0 until child.childCount) {
                        val btn = child.getChildAt(x)
                        if (btn is TextView) {
                            if (btn.text != fullTable[yCord][xCord].toString()) {
                                btn.setBackgroundColor(Color.RED)
                                correct = false
                            }
                            xCord++
                        }
                    }
                    yCord++
                    xCord = 0
                }
            }
            if (correct) {
                val dialog = AlertDialog.Builder(this)
                dialog.setMessage("Судоку решено!")
                dialog.setCancelable(false)
                dialog.setPositiveButton(
                    "OK"
                ) { dialog1, _ ->
                    dialog1.cancel()
                }
                dialog.show()
            }
        }
        binding.restart.setOnClickListener() {
            sendTextView = binding.TextView1
            fullTable = sudokuGenerator.generate()
            table = sudokuGenerator.makePartlyFilled(fullTable, 20 * (mode + 1))
            xCord = 0
            yCord = 0
            for (i in 0 until a) {
                val child: View = layout.getChildAt(i)
                if (child is TableRow) {
                    for (x in 0 until child.childCount) {
                        val btn = child.getChildAt(x)
                        if (btn is TextView) {
                            tmp = table[yCord][xCord]
                            if (tmp == 0) {
                                sendTextView = btn
                                btn.text = ""
                                btn.setBackgroundColor(Color.LTGRAY)
                            } else {
                                btn.text = table[yCord][xCord].toString()
                                btn.setBackgroundColor(Color.GRAY)
                            }
                            xCord++
                        }
                    }
                    yCord++
                    xCord = 0
                }
            }
            TextViewController(
                binding,
                table,
                fullTable,
                sendTextView,
                Color.LTGRAY,
                Color.DKGRAY
            ).allListener()
        }
        binding.back.setOnClickListener() {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}
