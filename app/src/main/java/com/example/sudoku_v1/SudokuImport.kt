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

class SudokuImport : AppCompatActivity() {
    var fullTable = Array(9) { IntArray(9) { 0 } }
    var fixShowWrong: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        fixShowWrong = showWrong
        showWrong = false
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        val binding = ActivitySudokuStandartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val layout = findViewById<TableLayout>(R.id.tableLayout)
        val a: Int = layout.childCount
        var xCord: Int = 0
        var yCord: Int = 0
        var tmp: Int = 0;
        var sendTextView: TextView = binding.TextView1
        var table = Array(9) { IntArray(9) { 0 } }
        for (i in 0 until a) {
            val child: View = layout.getChildAt(i)
            if (child is TableRow) {
                for (x in 0 until child.childCount) {
                    val btn = child.getChildAt(x)
                    if (btn is TextView) {
                        btn.setBackgroundColor(Color.LTGRAY)
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
            var table2 = Array(9) { IntArray(9) { 0 } }
            xCord = 0
            yCord = 0
            for (i in 0 until a) {
                val child: View = layout.getChildAt(i)
                if (child is TableRow) {
                    for (x in 0 until child.childCount) {
                        val btn = child.getChildAt(x)
                        if (btn is TextView) {
                            if (btn.text != "") {
                                table2[yCord][xCord] = btn.text.toString().toInt()
                            } else {
                                table2[yCord][xCord] = 0
                            }
                            xCord++
                        }
                    }
                    yCord++
                    xCord = 0
                }
            }
            if (isValidSudoku(table2) && solveSudoku(table2)) {
                val msg: String
                if (isUniqueSolution(table2)) {
                    msg = "Судоку имеет несколько решений. Показать одно из них?"
                } else {
                    msg = "Судоку имеет единственное решение. Показать?"
                }
                val dialog = AlertDialog.Builder(this)
                dialog.setMessage(msg)
                dialog.setCancelable(false)
                dialog.setPositiveButton(
                    "Да"
                ) { dialog1, _ ->
                    dialog1.cancel()
                    xCord = 0
                    yCord = 0
                    for (i in 0 until a) {
                        val child: View = layout.getChildAt(i)
                        if (child is TableRow) {
                            for (x in 0 until child.childCount) {
                                val btn = child.getChildAt(x)
                                if (btn is TextView) {
                                    tmp = fullTable[yCord][xCord]
                                    if (tmp == 0) {
                                        sendTextView = btn
                                        btn.setBackgroundColor(Color.LTGRAY)
                                    } else {
                                        btn.text = fullTable[yCord][xCord].toString()
                                        btn.setBackgroundColor(Color.GRAY)
                                    }
                                    xCord++
                                }
                            }
                            yCord++
                            xCord = 0
                        }
                    }
                }
                dialog.setNegativeButton("Нет") { dialog1, _ ->
                    dialog1.cancel()
                }
                val alertDialog = dialog.create()
                alertDialog.show()
            } else {
                val dialog = AlertDialog.Builder(this)
                dialog.setMessage("У данного судоку нет решений!")
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
            fullTable = Array(9) { IntArray(9) { 0 } }
            table = Array(9) { IntArray(9) { 0 } }
            xCord = 0
            yCord = 0
            for (i in 0 until a) {
                val child: View = layout.getChildAt(i)
                if (child is TableRow) {
                    for (x in 0 until child.childCount) {
                        val btn = child.getChildAt(x)
                        if (btn is TextView) {
                            btn.text = ""
                            btn.setBackgroundColor(Color.LTGRAY)
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

    fun isValidSudoku(board: Array<IntArray>): Boolean {
        val rows = Array(9) { BooleanArray(9) }
        val columns = Array(9) { BooleanArray(9) }
        val boxes = Array(9) { BooleanArray(9) }

        for (i in 0 until 9) {
            for (j in 0 until 9) {
                val num = board[i][j] - 1
                if (num in 0..8) {
                    val boxIndex = (i / 3) * 3 + j / 3
                    if (rows[i][num] || columns[j][num] || boxes[boxIndex][num]) {
                        return false
                    }
                    rows[i][num] = true
                    columns[j][num] = true
                    boxes[boxIndex][num] = true
                }
            }
        }

        return true
    }

    fun solveSudoku(board: Array<IntArray>): Boolean {
        for (i in 0 until 9) {
            for (j in 0 until 9) {
                if (board[i][j] == 0) {
                    for (num in 1..9) {
                        if (isValidMove(board, i, j, num)) {
                            board[i][j] = num
                            if (solveSudoku(board) && isUniqueSolution(board)) {
                                fullTable[i][j] = num
                                return true
                            }
                            board[i][j] = 0
                        }
                    }
                    return false
                }
            }
        }
        return true
    }

    fun isValidMove(board: Array<IntArray>, row: Int, col: Int, num: Int): Boolean {
        for (i in 0 until 9) {
            if (board[row][i] == num || board[i][col] == num) {
                return false
            }
        }

        val boxRowStart = 3 * (row / 3)
        val boxColStart = 3 * (col / 3)
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                if (board[boxRowStart + i][boxColStart + j] == num) {
                    return false
                }
            }
        }
        return true
    }

    fun isSecondSolution(board: Array<IntArray>): Boolean {
        for (i in 0 until 9) {
            for (j in 0 until 9) {
                if (board[i][j] == 0) {
                    for (num in 1..9) {
                        if (isValidMove(board, i, j, num)) {
                            board[i][j] = num
                            if (isSecondSolution(board) && isUniqueSolution(board)) {
                                return true
                            }
                            board[i][j] = 0
                        }
                    }
                    return false
                }
            }
        }
        return true
    }

    fun isUniqueSolution(board: Array<IntArray>): Boolean {
        val copy = Array(9) { row ->
            IntArray(9) { col ->
                board[row][col]
            }
        }
        for (i in 0 until 9) {
            for (j in 0 until 9) {
                if (copy[i][j] == 0) {
                    copy[i][j] = 1
                }
            }
        }
        return isSecondSolution(copy)
    }

    override fun onStop() {
        showWrong = fixShowWrong
        super.onStop()
    }
}