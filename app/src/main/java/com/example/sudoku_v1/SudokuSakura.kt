package com.example.sudoku_v1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import com.example.sudoku_v1.databinding.ActivitySudokuStandartBinding

class SudokuSakura : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySudokuStandartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val layout = findViewById<TableLayout>(R.id.tableLayout)
        val PINK: Int = -3827817
        val LTPINK: Int = -469290
        val LTBLUE: Int = -10981999
        binding.TextViewRestart.setBackgroundColor(PINK)
        binding.TextView.setBackgroundColor(PINK)
        val a: Int = layout.childCount
        var xCord: Int = 0
        var yCord: Int = 0
        var tmp: Int = 0;
        val sudokuGenerator = SudokuGenerator()
        var sendTextView: TextView = binding.TextView1
        var fullTable: Array<IntArray> = sudokuGenerator.generate()
        var table: Array<IntArray> = sudokuGenerator.makePartlyFilled(fullTable, 40)
        for (i in 0 until a) {
            val child: View = layout.getChildAt(i)
            if (child is TableRow) {
                for (x in 0 until child.childCount) {
                    val btn = child.getChildAt(x)
                    if (btn is TextView) {
                        tmp = table[yCord][xCord]
                        if (tmp == 0) {
                            sendTextView = btn
                            btn.setBackgroundColor(LTPINK)
                        } else {
                            btn.text = table[yCord][xCord].toString()
                            btn.setBackgroundColor(PINK)
                        }
                        xCord++
                    }
                }
                yCord++
                xCord = 0
            }
        }
        var TextViewController = TextViewController(binding, table, fullTable, sendTextView, LTPINK, LTBLUE)
        TextViewController.allListener()
        binding.TextView.setOnClickListener() {
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
                            }
                            xCord++
                        }
                    }
                    yCord++
                    xCord = 0
                }
            }
        }
        binding.TextViewRestart.setOnClickListener() {
            sendTextView = binding.TextView1
            fullTable = sudokuGenerator.generate()
            table = sudokuGenerator.makePartlyFilled(fullTable, 18)
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
                                btn.setBackgroundColor(LTPINK)
                            } else {
                                btn.text = table[yCord][xCord].toString()
                                btn.setBackgroundColor(PINK)
                            }
                            xCord++
                        }
                    }
                    yCord++
                    xCord = 0
                }
            }
            TextViewController = TextViewController(binding, table, fullTable, sendTextView, LTPINK, LTBLUE)
            TextViewController.allListener()
        }
    }
}
