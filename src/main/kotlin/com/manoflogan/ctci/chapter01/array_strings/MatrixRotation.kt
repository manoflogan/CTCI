package com.manoflogan.ctci.chapter01.array_strings

/**
 * Rotate matrix by 90 degrees.
 */
fun main() {
    val matrix = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )
    rotateMatrix(matrix)
    matrix.forEach { intArray ->
        println(intArray.joinToString(separator = " "))
    }
}

private fun rotateMatrix(matrix: Array<IntArray>) : Array<IntArray> {
    if (matrix.isEmpty() || matrix[0].isEmpty()) {
        return matrix
    }
    matrix.forEachIndexed { index, intArray ->
        for (jIndex in index until intArray.size) {
            val temp = matrix[index][jIndex]
            matrix[index][jIndex] = matrix[jIndex][index]
            matrix[jIndex][index] = temp
        }
    }
    return matrix
}
