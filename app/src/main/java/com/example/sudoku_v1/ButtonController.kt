package com.example.sudoku_v1

import android.graphics.Color
import android.widget.Button
import android.widget.TextView
import com.example.sudoku_v1.databinding.ActivityMainBinding
import com.example.sudoku_v1.databinding.ActivitySudokuStandartBinding

class TextViewController (private val binding: ActivitySudokuStandartBinding,
        private val table: Array<IntArray>,
        private val fullGrid: Array<IntArray>,
        private var currentTextView: TextView,
        private val baseColor: Int,
        private val extraColor: Int) {
            private var xCord: Int = 0
            private var yCord: Int = 0
            private fun superListener(TextView: TextView) {
                currentTextView.setBackgroundColor(baseColor)
                currentTextView = TextView
        currentTextView.setBackgroundColor(extraColor)
    }
    fun allListener() {
        binding.TextView1.setOnClickListener() {
            if (table[0][0] == 0) {
                xCord = 0
                yCord = 0
                superListener(binding.TextView1)
            }
        }
        binding.TextView2.setOnClickListener() {
            if (table[0][1] == 0) {
                xCord = 0
                yCord = 1
                superListener(binding.TextView2)
            }
        }
        binding.TextView3.setOnClickListener() {
            if (table[0][2] == 0) {
                xCord = 0
                yCord = 2
                superListener(binding.TextView3)
            }
        }
        binding.TextView4.setOnClickListener() {
            if (table[0][3] == 0) {
                xCord = 0
                yCord = 3
                superListener(binding.TextView4)
            }
        }
        binding.TextView5.setOnClickListener() {
            if (table[0][4] == 0) {
                xCord = 0
                yCord = 4
                superListener(binding.TextView5)
            }
        }
        binding.TextView6.setOnClickListener() {
            if (table[0][5] == 0) {
                xCord = 0
                yCord = 5
                superListener(binding.TextView6)
            }
        }
        binding.TextView7.setOnClickListener() {
            if (table[0][6] == 0) {
                xCord = 0
                yCord = 6
                superListener(binding.TextView7)
            }
        }
        binding.TextView8.setOnClickListener() {
            if (table[0][7] == 0) {
                xCord = 0
                yCord = 7
                superListener(binding.TextView8)
            }
        }
        binding.TextView9.setOnClickListener() {
            if (table[0][8] == 0) {
                xCord = 0
                yCord = 8
                superListener(binding.TextView9)
            }
        }
        binding.TextView10.setOnClickListener() {
            if (table[1][0] == 0) {
                xCord = 1
                yCord = 0
                superListener(binding.TextView10)
            }
        }
        binding.TextView11.setOnClickListener() {
            if (table[1][1] == 0) {
                xCord = 1
                yCord = 1
                superListener(binding.TextView11)
            }
        }
        binding.TextView12.setOnClickListener() {
            if (table[1][2] == 0) {
                xCord = 1
                yCord = 2
                superListener(binding.TextView12)
            }
        }
        binding.TextView13.setOnClickListener() {
            if (table[1][3] == 0) {
                xCord = 1
                yCord = 3
                superListener(binding.TextView13)
            }
        }
        binding.TextView14.setOnClickListener() {
            if (table[1][4] == 0) {
                xCord = 1
                yCord = 4
                superListener(binding.TextView14)
            }
        }
        binding.TextView15.setOnClickListener() {
            if (table[1][5] == 0) {
                xCord = 1
                yCord = 5
                superListener(binding.TextView15)
            }
        }
        binding.TextView16.setOnClickListener() {
            if (table[1][6] == 0) {
                xCord = 1
                yCord = 6
                superListener(binding.TextView16)
            }
        }
        binding.TextView17.setOnClickListener() {
            if (table[1][7] == 0) {
                xCord = 1
                yCord = 7
                superListener(binding.TextView17)
            }
        }
        binding.TextView18.setOnClickListener() {
            if (table[1][8] == 0) {
                xCord = 1
                yCord = 8
                superListener(binding.TextView18)
            }
        }
        binding.TextView19.setOnClickListener() {
            if (table[2][0] == 0) {
                xCord = 2
                yCord = 0
                superListener(binding.TextView19)
            }
        }
        binding.TextView20.setOnClickListener() {
            if (table[2][1] == 0) {
                xCord = 2
                yCord = 1
                superListener(binding.TextView20)
            }
        }
        binding.TextView21.setOnClickListener() {
            if (table[2][2] == 0) {
                xCord = 2
                yCord = 2
                superListener(binding.TextView21)
            }
        }
        binding.TextView22.setOnClickListener() {
            if (table[2][3] == 0) {
                xCord = 2
                yCord = 3
                superListener(binding.TextView22)
            }
        }
        binding.TextView23.setOnClickListener() {
            if (table[2][4] == 0) {
                xCord = 2
                yCord = 4
                superListener(binding.TextView23)
            }
        }
        binding.TextView24.setOnClickListener() {
            if (table[2][5] == 0) {
                xCord = 2
                yCord = 5
                superListener(binding.TextView24)
            }
        }
        binding.TextView25.setOnClickListener() {
            if (table[2][6] == 0) {
                xCord = 2
                yCord = 6
                superListener(binding.TextView25)
            }
        }
        binding.TextView26.setOnClickListener() {
            if (table[2][7] == 0) {
                xCord = 2
                yCord = 7
                superListener(binding.TextView26)
            }
        }
        binding.TextView27.setOnClickListener() {
            if (table[2][8] == 0) {
                xCord = 2
                yCord = 8
                superListener(binding.TextView27)
            }
        }
        binding.TextView28.setOnClickListener() {
            if (table[3][0] == 0) {
                xCord = 3
                yCord = 0
                superListener(binding.TextView28)
            }
        }
        binding.TextView29.setOnClickListener() {
            if (table[3][1] == 0) {
                xCord = 3
                yCord = 1
                superListener(binding.TextView29)
            }
        }
        binding.TextView30.setOnClickListener() {
            if (table[3][2] == 0) {
                xCord = 3
                yCord = 2
                superListener(binding.TextView30)
            }
        }
        binding.TextView31.setOnClickListener() {
            if (table[3][3] == 0) {
                xCord = 3
                yCord = 3
                superListener(binding.TextView31)
            }
        }
        binding.TextView32.setOnClickListener() {
            if (table[3][4] == 0) {
                xCord = 3
                yCord = 4
                superListener(binding.TextView32)
            }
        }
        binding.TextView33.setOnClickListener() {
            if (table[3][5] == 0) {
                xCord = 3
                yCord = 5
                superListener(binding.TextView33)
            }
        }
        binding.TextView34.setOnClickListener() {
            if (table[3][6] == 0) {
                xCord = 3
                yCord = 6
                superListener(binding.TextView34)
            }
        }
        binding.TextView35.setOnClickListener() {
            if (table[3][7] == 0) {
                xCord = 3
                yCord = 7
                superListener(binding.TextView35)
            }
        }
        binding.TextView36.setOnClickListener() {
            if (table[3][8] == 0) {
                xCord = 3
                yCord = 8
                superListener(binding.TextView36)
            }
        }
        binding.TextView37.setOnClickListener() {
            if (table[4][0] == 0) {
                xCord = 4
                yCord = 0
                superListener(binding.TextView37)
            }
        }
        binding.TextView38.setOnClickListener() {
            if (table[4][1] == 0) {
                xCord = 4
                yCord = 1
                superListener(binding.TextView38)
            }
        }
        binding.TextView39.setOnClickListener() {
            if (table[4][2] == 0) {
                xCord = 4
                yCord = 2
                superListener(binding.TextView39)
            }
        }
        binding.TextView40.setOnClickListener() {
            if (table[4][3] == 0) {
                xCord = 4
                yCord = 3
                superListener(binding.TextView40)
            }
        }
        binding.TextView41.setOnClickListener() {
            if (table[4][4] == 0) {
                xCord = 4
                yCord = 4
                superListener(binding.TextView41)
            }
        }
        binding.TextView42.setOnClickListener() {
            if (table[4][5] == 0) {
                xCord = 4
                yCord = 5
                superListener(binding.TextView42)
            }
        }
        binding.TextView43.setOnClickListener() {
            if (table[4][6] == 0) {
                xCord = 4
                yCord = 6
                superListener(binding.TextView43)
            }
        }
        binding.TextView44.setOnClickListener() {
            if (table[4][7] == 0) {
                xCord = 4
                yCord = 7
                superListener(binding.TextView44)
            }
        }
        binding.TextView45.setOnClickListener() {
            if (table[4][8] == 0) {
                xCord = 4
                yCord = 8
                superListener(binding.TextView45)
            }
        }
        binding.TextView46.setOnClickListener() {
            if (table[5][0] == 0) {
                xCord = 5
                yCord = 0
                superListener(binding.TextView46)
            }
        }
        binding.TextView47.setOnClickListener() {
            if (table[5][1] == 0) {
                xCord = 5
                yCord = 1
                superListener(binding.TextView47)
            }
        }
        binding.TextView48.setOnClickListener() {
            if (table[5][2] == 0) {
                xCord = 5
                yCord = 2
                superListener(binding.TextView48)
            }
        }
        binding.TextView49.setOnClickListener() {
            if (table[5][3] == 0) {
                xCord = 5
                yCord = 3
                superListener(binding.TextView49)
            }
        }
        binding.TextView50.setOnClickListener() {
            if (table[5][4] == 0) {
                xCord = 5
                yCord = 4
                superListener(binding.TextView50)
            }
        }
        binding.TextView51.setOnClickListener() {
            if (table[5][5] == 0) {
                xCord = 5
                yCord = 5
                superListener(binding.TextView51)
            }
        }
        binding.TextView52.setOnClickListener() {
            if (table[5][6] == 0) {
                xCord = 5
                yCord = 6
                superListener(binding.TextView52)
            }
        }
        binding.TextView53.setOnClickListener() {
            if (table[5][7] == 0) {
                xCord = 5
                yCord = 7
                superListener(binding.TextView53)
            }
        }
        binding.TextView54.setOnClickListener() {
            if (table[5][8] == 0) {
                xCord = 5
                yCord = 8
                superListener(binding.TextView54)
            }
        }
        binding.TextView55.setOnClickListener() {
            if (table[6][0] == 0) {
                xCord = 6
                yCord = 0
                superListener(binding.TextView55)
            }
        }
        binding.TextView56.setOnClickListener() {
            if (table[6][1] == 0) {
                xCord = 6
                yCord = 1
                superListener(binding.TextView56)
            }
        }
        binding.TextView57.setOnClickListener() {
            if (table[6][2] == 0) {
                xCord = 6
                yCord = 2
                superListener(binding.TextView57)
            }
        }
        binding.TextView58.setOnClickListener() {
            if (table[6][3] == 0) {
                xCord = 6
                yCord = 3
                superListener(binding.TextView58)
            }
        }
        binding.TextView59.setOnClickListener() {
            if (table[6][4] == 0) {
                xCord = 6
                yCord = 4
                superListener(binding.TextView59)
            }
        }
        binding.TextView60.setOnClickListener() {
            if (table[6][5] == 0) {
                xCord = 6
                yCord = 5
                superListener(binding.TextView60)
            }
        }
        binding.TextView61.setOnClickListener() {
            if (table[6][6] == 0) {
                xCord = 6
                yCord = 6
                superListener(binding.TextView61)
            }
        }
        binding.TextView62.setOnClickListener() {
            if (table[6][7] == 0) {
                xCord = 6
                yCord = 7
                superListener(binding.TextView62)
            }
        }
        binding.TextView63.setOnClickListener() {
            if (table[6][8] == 0) {
                xCord = 6
                yCord = 8
                superListener(binding.TextView63)
            }
        }
        binding.TextView64.setOnClickListener() {
            if (table[7][0] == 0) {
                xCord = 7
                yCord = 0
                superListener(binding.TextView64)
            }
        }
        binding.TextView65.setOnClickListener() {
            if (table[7][1] == 0) {
                xCord = 7
                yCord = 1
                superListener(binding.TextView65)
            }
        }
        binding.TextView66.setOnClickListener() {
            if (table[7][2] == 0) {
                xCord = 7
                yCord = 2
                superListener(binding.TextView66)
            }
        }
        binding.TextView67.setOnClickListener() {
            if (table[7][3] == 0) {
                xCord = 7
                yCord = 3
                superListener(binding.TextView67)
            }
        }
        binding.TextView68.setOnClickListener() {
            if (table[7][4] == 0) {
                xCord = 7
                yCord = 4
                superListener(binding.TextView68)
            }
        }
        binding.TextView69.setOnClickListener() {
            if (table[7][5] == 0) {
                xCord = 7
                yCord = 5
                superListener(binding.TextView69)
            }
        }
        binding.TextView70.setOnClickListener() {
            if (table[7][6] == 0) {
                xCord = 7
                yCord = 6
                superListener(binding.TextView70)
            }
        }
        binding.TextView71.setOnClickListener() {
            if (table[7][7] == 0) {
                xCord = 7
                yCord = 7
                superListener(binding.TextView71)
            }
        }
        binding.TextView72.setOnClickListener() {
            if (table[7][8] == 0) {
                xCord = 7
                yCord = 8
                superListener(binding.TextView72)
            }
        }
        binding.TextView73.setOnClickListener() {
            if (table[8][0] == 0) {
                xCord = 8
                yCord = 0
                superListener(binding.TextView73)
            }
        }
        binding.TextView74.setOnClickListener() {
            if (table[8][1] == 0) {
                xCord = 8
                yCord = 1
                superListener(binding.TextView74)
            }
        }
        binding.TextView75.setOnClickListener() {
            if (table[8][2] == 0) {
                xCord = 8
                yCord = 2
                superListener(binding.TextView75)
            }
        }
        binding.TextView76.setOnClickListener() {
            if (table[8][3] == 0) {
                xCord = 8
                yCord = 3
                superListener(binding.TextView76)
            }
        }
        binding.TextView77.setOnClickListener() {
            if (table[8][4] == 0) {
                xCord = 8
                yCord = 4
                superListener(binding.TextView77)
            }
        }
        binding.TextView78.setOnClickListener() {
            if (table[8][5] == 0) {
                xCord = 8
                yCord = 5
                superListener(binding.TextView78)
            }
        }
        binding.TextView79.setOnClickListener() {
            if (table[8][6] == 0) {
                xCord = 8
                yCord = 6
                superListener(binding.TextView79)
            }
        }
        binding.TextView80.setOnClickListener() {
            if (table[8][7] == 0) {
                xCord = 8
                yCord = 7
                superListener(binding.TextView80)
            }
        }
        binding.TextView81.setOnClickListener() {
            if (table[8][8] == 0) {
                xCord = 8
                yCord = 8
                superListener(binding.TextView81)
            }
        }
        binding.TextViewPush0.setOnClickListener() {
            currentTextView.text = ""
            currentTextView.setBackgroundColor(extraColor)
        }
        binding.TextViewPush1.setOnClickListener() {
            currentTextView.text = "1"
            if (fullGrid[xCord][yCord] != 1) {
                currentTextView.setBackgroundColor(0xFFFF0000.toInt())
            } else {
                currentTextView.setBackgroundColor(extraColor)
            }
        }
        binding.TextViewPush2.setOnClickListener() {
            currentTextView.text = "2"
            if (fullGrid[xCord][yCord] != 2) {
                currentTextView.setBackgroundColor(0xFFFF0000.toInt())
            } else {
                currentTextView.setBackgroundColor(extraColor)
            }
        }
        binding.TextViewPush3.setOnClickListener() {
            currentTextView.text = "3"
            if (fullGrid[xCord][yCord] != 3) {
                currentTextView.setBackgroundColor(0xFFFF0000.toInt())
            } else {
                currentTextView.setBackgroundColor(extraColor)
            }
        }
        binding.TextViewPush4.setOnClickListener() {
            currentTextView.text = "4"
            if (fullGrid[xCord][yCord] != 4) {
                currentTextView.setBackgroundColor(0xFFFF0000.toInt())
            } else {
                currentTextView.setBackgroundColor(extraColor)
            }
        }
        binding.TextViewPush5.setOnClickListener() {
            currentTextView.text = "5"
            if (fullGrid[xCord][yCord] != 5) {
                currentTextView.setBackgroundColor(0xFFFF0000.toInt())
            } else {
                currentTextView.setBackgroundColor(extraColor)
            }
        }
        binding.TextViewPush6.setOnClickListener() {
            currentTextView.text = "6"
            if (fullGrid[xCord][yCord] != 6) {
                currentTextView.setBackgroundColor(0xFFFF0000.toInt())
            } else {
                currentTextView.setBackgroundColor(extraColor)
            }
        }
        binding.TextViewPush7.setOnClickListener() {
            currentTextView.text = "7"
            if (fullGrid[xCord][yCord] != 7) {
                currentTextView.setBackgroundColor(0xFFFF0000.toInt())
            } else {
                currentTextView.setBackgroundColor(extraColor)
            }
        }
        binding.TextViewPush8.setOnClickListener() {
            currentTextView.text = "8"
            if (fullGrid[xCord][yCord] != 8) {
                currentTextView.setBackgroundColor(0xFFFF0000.toInt())
            } else {
                currentTextView.setBackgroundColor(extraColor)
            }
        }
        binding.TextViewPush9.setOnClickListener() {
            currentTextView.text = "9"
            if (fullGrid[xCord][yCord] != 9) {
                currentTextView.setBackgroundColor(0xFFFF0000.toInt())
            } else {
                currentTextView.setBackgroundColor(extraColor)
            }
        }
    }
}

