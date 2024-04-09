package com.manoflogan.ctci.chapter01.array_strings

/**
 * Given a smaller string, and a bigger string, design an algorigthm to find all permutations of
 * the shorter string withing the longer one. Print the location of each permutation
 */
// Sliding window technique
fun main() {
    println(findPermutationsOfEachLocation("abbc", "cbabadcbbabbcbabaabccbabc"))
}

private fun findPermutationsOfEachLocation(smallString: String, largeString: String): List<Int> {
    if (smallString.length > largeString.length) {
        return listOf()
    }

    val primeArray = intArrayOf(
        2, 3, 5, 7, 11, 13, 17,
        19, 23, 29, 31, 37, 41, 43,
        47, 53, 59, 61, 67, 71, 73,
        79, 83, 89, 97, 101
    )
    var substringProduct = 1
    smallString.forEach { character: Char ->
        substringProduct *= primeArray[character - 'a']
    }
    var largeProduct = 1
    val smallStringLength = smallString.length
    for (index in 0..< smallStringLength) {
        largeProduct *= primeArray[largeString[index] - 'a']
    }
    val indicesList = mutableListOf<Int>()
    if (largeProduct == substringProduct) {
        indicesList.add(0) // First index
    }
    for (index in smallStringLength until largeString.length) {
        largeProduct /= primeArray[largeString[index - smallStringLength] - 'a']
        largeProduct *= primeArray[largeString[index] - 'a']
        if (largeProduct == substringProduct) {
            indicesList.add(index - smallStringLength + 1)
            println(largeString.substring(IntRange(index - smallStringLength + 1, index)))
        }
    }
    return indicesList
}
