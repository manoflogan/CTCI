package com.manoflogan.ctci.chapter01.array_strings

/**
 * Implement a method to perform string compression usinig counts of repeated characters. For
 * example, "aabcccccaaa" is represented as "a2b1c5a3". If the compressed string is longer than the
 * original string, then we should return the original string.
 */
fun main() {
    println(compressString("aabcccccaaa"))
    println(compressString("aabcccccaaae"))
    println(compressString("abc"))
}

private fun compressString(input: String): String {
    if (input.isEmpty()) {
        return input
    }
    val stringBuilder = StringBuilder()
    var count = 1 // First character count
    var index = 0
    while (index < (input.length - 1)) {
        if (input[index] == input[index + 1]) {
            count ++
        } else {
            with(stringBuilder) {
                append(input[index])
                append(count)
            }
            count = 1
        }
        index ++
    }
    with(stringBuilder) {
        if (input[index] == input[index - 1]) {
            append(input[index])
            append(count)
        }  else {
            append(input[index])
            append(1)
        }
    }
    return stringBuilder.toString().takeIf {
        it.length < input.length
    } ?: input
}
