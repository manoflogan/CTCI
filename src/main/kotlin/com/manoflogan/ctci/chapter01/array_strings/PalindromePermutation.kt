package com.manoflogan.ctci.chapter01.array_strings

/**
 * Given a string, write a function to check if it is a permutation of a palindrome. It does not
 * have to be a word in dictionary, and you can ignore casing, and non letter characters
 *
 * For exampll: Tact Coa -> permutations ("taco cat", "acto cta")
 */
fun main() {
    println(isPalindrome("Tact Coa"))
    println(isPalindrome("malaYaLam"))
    println(isPalindrome("abba"))
}

private fun isPalindrome(input: String): Boolean {
    val inputString = input.lowercase().replace(" ", "")
    val characterMap = mutableMapOf<Char, Int>()
    inputString.forEach {  character ->
        if (character == ' ') {
            return@forEach
        }
        val existingCount = characterMap.getOrPut(character) {0}
        characterMap[character] = existingCount + 1
    }
    // If the string has even length, then there should be no letters that have an odd number of
    // characers
    // Similarly if the string has an odd length, then there should be just letter that has odd
    // number of characters
    val oddNumberCount = characterMap.count { entry: Map.Entry<Char, Int> ->
        entry.value %2 == 1
    }
    return if (inputString.length % 2 == 0) {
        oddNumberCount == 0
    } else {
        oddNumberCount == 1
    }
}
