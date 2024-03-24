package com.manoflogan.ctci.chapter01.array_strings

/**
 * Given two strings, write a problem to decide one is a permutation of the other
 */
fun main() {
    println(isPermutation("kartik", "kitrak"))
}

fun isPermutation(first: String, second: String): Boolean {
    if (first.length != second.length) {
        return false
    }
    val primeNumberArray = intArrayOf(
        2, 3, 5, 7, 11, 13, 17,
        19, 23, 29, 31, 37, 41, 43,
        47, 53, 59, 61, 67, 71, 73,
        79, 83, 89, 97, 101
    )
    var initialProduct = 1
    first.forEach { character ->
        initialProduct *= primeNumberArray[character - 'a']
    }
    second.forEach { character ->
        val primeNumber = primeNumberArray[character - 'a']
        // If the letter did not exist in the original number, then the modulo will not be 0
        if (initialProduct.mod(primeNumber) != 0) {
            return false
        }
        initialProduct /= primeNumber
    }
    return initialProduct == 1
}
