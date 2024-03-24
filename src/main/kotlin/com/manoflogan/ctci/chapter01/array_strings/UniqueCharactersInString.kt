package com.manoflogan.ctci.chapter01.array_strings

/**
 * Implement an algorithm if a sring has all unique characters. What if you can't use additional
 * data structures
 */

fun main() {
    println(isUnique("kartik"))
    println(isUnique("shounak"))
}

private fun isUnique(input: String): Boolean {
    val primeNumberArray = intArrayOf(
        2, 3, 5, 7, 11, 13, 17,
        19, 23, 29, 31, 37, 41, 43,
        47, 53, 59, 61, 67, 71, 73,
        79, 83, 89, 97, 101
    )
    var product: Int = 1
    input.forEach { character ->
        val primeNumber = primeNumberArray[character - 'a']
        if (product.mod(primeNumber) == 0) {
            return false
        }
        product *= primeNumber
    }
    return true
}
