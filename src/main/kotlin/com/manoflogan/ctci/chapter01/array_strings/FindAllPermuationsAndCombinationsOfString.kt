package com.manoflogan.ctci.chapter01.array_strings

/**
 * Find permuations, and combinations of strings
 */
fun main() {
    println(generatePermutations("kartik"))
}

private fun generatePermutations(input: String): List<String> {
    if (input.isEmpty()) {
        return listOf()
    }
    val permList = mutableListOf<String>()
    generatePermutations(input, "", permList)
    return permList
}

private fun generatePermutations(input: String, fragment: String, permList: MutableList<String>) {
    if (input.isEmpty()) {
        permList.add(fragment)
        return
    }
    for (index in 0 until input.length) {
        val char = input[index]
        generatePermutations(
            buildString {
                append(input.substring(0, index))
                append(input.substring(index + 1))
            },
            buildString {
                append(fragment)
                append(char)
            },
            permList
        )
    }
}
