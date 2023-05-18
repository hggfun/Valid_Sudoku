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
import com.example.sudoku_v1.databinding.ActivitySudokuBlocksBinding


public lateinit var currentTable: Array<IntArray>
public val PINK: Int = -3827817
public val DKGREEN: Int = -16756736
public val LTBLUE: Int = -16744264

class SudokuBlocks : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        val binding = ActivitySudokuBlocksBinding.inflate(layoutInflater)
        setContentView(binding.root)
        colorBaseButtons(binding)
        val layout = findViewById<TableLayout>(R.id.tableLayout)
        val a: Int = layout.childCount
        var xCord: Int = 0
        var yCord: Int = 0
        var tmp: Int = 0;
        val sudokuGenerator = SudokuGenerator()
        var sendTextView: TextView = binding.TextView1
        var fullTable: Array<IntArray> = sudokuGenerator.generate()
        var table: Array<IntArray> = sudokuGenerator.makePartlyFilled(fullTable, 20 * (mode + 1))
        currentTable = table.map { it.copyOf() }.toTypedArray()
        for (i in 0 until a) {
            val child: View = layout.getChildAt(i)
            if (child is TableRow) {
                for (x in 0 until child.childCount) {
                    val btn = child.getChildAt(x)
                    if (btn is TextView) {
                        tmp = table[yCord][xCord]
                        if (colorize(tmp, btn)) {
                            sendTextView = btn
                        }
                        xCord++
                    }
                }
                yCord++
                xCord = 0
            }
        }
        BlocksController(binding, table, fullTable, sendTextView).allListener()
        binding.check.setOnClickListener() {
            var correct:Boolean = true
            xCord = 0;
            yCord = 0
            for (i in 0 until a) {
                val child: View = layout.getChildAt(i)
                if (child is TableRow) {
                    for (x in 0 until child.childCount) {
                        val btn = child.getChildAt(x)
                        if (btn is TextView) {
                            if (currentTable[yCord][xCord] != fullTable[yCord][xCord]) {
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
            currentTable = table.map { it.copyOf() }.toTypedArray()
            xCord = 0
            yCord = 0
            for (i in 0 until a) {
                val child: View = layout.getChildAt(i)
                if (child is TableRow) {
                    for (x in 0 until child.childCount) {
                        val btn = child.getChildAt(x)
                        if (btn is TextView) {
                            tmp = table[yCord][xCord]
                            if (colorize(tmp, btn)) {
                                sendTextView = btn
                            }
                            xCord++
                        }
                    }
                    yCord++
                    xCord = 0
                }
            }
            BlocksController(binding, table, fullTable, sendTextView).allListener()
        }
        binding.back.setOnClickListener() {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}

fun colorize(tmp: Int, btn: TextView) : Boolean {
    if (tmp == 0) {
        btn.setBackgroundColor(Color.WHITE)
        btn.text = "+"
        return true
    } else {
        btn.text = ""
        when(tmp) {
            1 -> btn.setBackgroundColor(PINK)
            2 -> btn.setBackgroundColor(LTBLUE)
            3 -> btn.setBackgroundColor(Color.BLUE)
            4 -> btn.setBackgroundColor(Color.CYAN)
            5 -> btn.setBackgroundColor(Color.DKGRAY)
            6 -> btn.setBackgroundColor(Color.GRAY)
            7 -> btn.setBackgroundColor(Color.GREEN)
            8 -> btn.setBackgroundColor(DKGREEN)
            9 -> btn.setBackgroundColor(Color.MAGENTA)
        }
        return false
    }
}

fun colorBaseButtons(binding: ActivitySudokuBlocksBinding) {
    binding.TextViewChange0.setBackgroundColor(Color.WHITE)
    binding.TextViewChange1.setBackgroundColor(PINK)
    binding.TextViewChange2.setBackgroundColor(LTBLUE)
    binding.TextViewChange3.setBackgroundColor(Color.BLUE)
    binding.TextViewChange4.setBackgroundColor(Color.CYAN)
    binding.TextViewChange5.setBackgroundColor(Color.DKGRAY)
    binding.TextViewChange6.setBackgroundColor(Color.GRAY)
    binding.TextViewChange7.setBackgroundColor(Color.GREEN)
    binding.TextViewChange8.setBackgroundColor(DKGREEN)
    binding.TextViewChange9.setBackgroundColor(Color.MAGENTA)
}
