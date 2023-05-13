package com.example.sudoku_v1

import kotlin.random.Random

class SudokuGenerator {

    companion object {
        private const val SIZE = 9
        private const val BOX_SIZE = 3
        private const val EMPTY_CELL = 0
    }

    fun generate(): Array<IntArray> {
        val grid = Array(SIZE) { IntArray(SIZE) }
        fillDiagonalBoxes(grid)
        fillRemaining(grid, 0, BOX_SIZE)
        return grid
    }
    fun makePartlyFilled(fullGrid: Array<IntArray>, numCellsToRemove: Int): Array<IntArray> {
        val grid = fullGrid.map { it.copyOf() }.toTypedArray() // Make a copy of the full grid
        val cells = mutableListOf<Pair<Int, Int>>()

        // Collect all the non-empty cells in the grid
        for (row in 0 until SIZE) {
            for (col in 0 until SIZE) {
                if (grid[row][col] != EMPTY_CELL) {
                    cells.add(Pair(row, col))
                }
            }
        }

        // Shuffle the list of non-empty cells
        cells.shuffle()

        // Remove the specified number of cells from the shuffled list
        for (i in 0 until numCellsToRemove) {
            val cell = cells[i]
            grid[cell.first][cell.second] = EMPTY_CELL
        }

        return grid
    }


    private fun fillDiagonalBoxes(grid: Array<IntArray>) {
        for (i in 0 until SIZE step BOX_SIZE) {
            fillBox(grid, i, i)
        }
    }

    private fun fillBox(grid: Array<IntArray>, row: Int, col: Int) {
        var num: Int
        for (i in 0 until BOX_SIZE) {
            for (j in 0 until BOX_SIZE) {
                do {
                    num = Random.nextInt(1, SIZE + 1)
                } while (!isValid(grid, row, col, num))
                grid[row + i][col + j] = num
            }
        }
    }

    private fun fillRemaining(grid: Array<IntArray>, row: Int, col: Int): Boolean {
        var currentRow = row
        var currentCol = col

        if (currentCol >= SIZE && currentRow < SIZE - 1) {
            currentRow++
            currentCol = 0
        }

        if (currentRow >= SIZE && currentCol >= SIZE) {
            return true
        }

        if (currentRow < BOX_SIZE) {
            if (currentCol < BOX_SIZE) {
                currentCol = BOX_SIZE
            }
        } else if (currentRow < SIZE - BOX_SIZE) {
            if (currentCol == (currentRow / BOX_SIZE) * BOX_SIZE) {
                currentCol += BOX_SIZE
            }
        } else {
            if (currentCol == SIZE - BOX_SIZE) {
                currentRow++
                currentCol = 0
                if (currentRow >= SIZE) {
                    return true
                }
            }
        }

        for (num in 1..SIZE) {
            if (isValid(grid, currentRow, currentCol, num)) {
                grid[currentRow][currentCol] = num
                if (fillRemaining(grid, currentRow, currentCol + 1)) {
                    return true
                }
                grid[currentRow][currentCol] = EMPTY_CELL
            }
        }

        return false
    }

    private fun isValid(grid: Array<IntArray>, row: Int, col: Int, num: Int): Boolean {
        for (i in 0 until SIZE) {
            if (grid[row][i] == num) {
                return false
            }
            if (grid[i][col] == num) {
                return false
            }
        }
        val boxRowStart = row - row % BOX_SIZE
        val boxColStart = col - col % BOX_SIZE
        for (i in 0 until BOX_SIZE) {
            for (j in 0 until BOX_SIZE) {
                if (grid[boxRowStart + i][boxColStart + j] == num) {
                    return false
                }
            }
        }
        return true
    }
}