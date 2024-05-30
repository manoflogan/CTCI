package com.manoflogan.ctci.chapter01.array_strings

/**
 * Write an algorithm such as if an element in M X N matrix is 0, then the entire row, and column is
 * set to 0.
 */
/*fun main() {
    val matrix = arrayOf(
        intArrayOf(2, 0, 3),
        intArrayOf(1, 7, 5),
        intArrayOf(0, 8, 10)
    )
    val matrixTwo = matrix.map {
        it.copyOf()
    }.toTypedArray()
    printMatrix(zeroMatrixOne(matrix))
    printMatrix(zeroMatrixTwo(matrixTwo))
}*/

private fun zeroMatrixOne(matrix: Array<IntArray>): Array<IntArray> {
    if (matrix.isEmpty() || matrix[0].isEmpty()) {
        return matrix
    }
    val zeroRows = mutableSetOf<Int>()
    val zeroColumns = mutableSetOf<Int>()
    matrix.forEachIndexed { index, intArray ->
        intArray.forEachIndexed { colIndex, elem ->
            if (elem == 0) {
                zeroRows.add(index)
                zeroColumns.add(colIndex)
            }
        }
    }
    zeroRows.forEach {row ->
        matrix[row].forEachIndexed { col, _ ->
            matrix[row][col] = 0
        }
    }
    zeroColumns.forEach {col ->
        matrix.forEachIndexed { row, _ ->
            matrix[row][col] = 0
        }

    }
    return matrix
}

private fun zeroMatrixTwo(matrix: Array<IntArray>): Array<IntArray> {
    if (matrix.isEmpty() || matrix[0].isEmpty()) {
        return matrix
    }
    // Iterate through the first row, and column
    val isFirstRowZero = matrix[0].any {elem ->
        elem == 0
    }
    var isFirstColumnZero = false
    for (index in 0 until matrix.size) {
        if (matrix[0][index] == 0) {
            isFirstColumnZero = true
            break
        }
    }
    // Initialise the first row, and first column as zero
    for (i in 1 until matrix.size) {
        for (j in 1 until matrix[i].size) {
            if (matrix[i][j] == 0) {
                matrix[i][0] = 0
                matrix[0][j] = 0
            }
        }
    }
    for (i in 1 until matrix.size) {
        for (j in 1 until matrix.size) {
            if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                matrix[i][j] = 0
            }
        }
    }
    // Initialise the first row and column
    if (isFirstRowZero) {
        for (index in 0 until matrix.size) {
            matrix[index][0] = 0
        }
    }
    if (isFirstColumnZero) {
        for (index in 0 until matrix[0].size) {
            matrix[0][index] = 0
        }
    }
    return matrix
}

private fun printMatrix(matrix: Array<IntArray>) {
    matrix.forEach {
        println(it.joinToString(" "))
    }
}
