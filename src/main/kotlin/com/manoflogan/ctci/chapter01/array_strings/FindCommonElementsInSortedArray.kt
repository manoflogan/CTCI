package com.manoflogan.ctci.chapter01.array_strings

/**
 * Given two sorted arrays, find the number of elements in common. The arrays are of the same length
 * and each have all distinct elements
 */
fun main() {
    println(findCommonElements(
        intArrayOf(13, 27, 35, 40, 49, 55, 59),
        intArrayOf(17, 35, 39, 40, 55, 58, 60)
    )
    )
}

private fun findCommonElements(firstArray: IntArray, secondArray: IntArray): List<Int> {
    if (firstArray.size != secondArray.size) {
        return emptyList()
    }
    var i = 0
    var j = 0
    val commonElementsList = mutableListOf<Int>()
    while (i < firstArray.size && j < secondArray.size) {
        if (firstArray[i] < secondArray[j]) {
            i++
        } else if (firstArray[i] > secondArray[j]) {
            j++
        } else {
            commonElementsList.add(firstArray[i])
            i++
            j++
        }
    }
    return commonElementsList
}
