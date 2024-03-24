package com.manoflogan.ctci.chapter01.array_strings

/**
 * Write a method to replace all spaces in a string with %20. You may assume that string has
 * sufficient space in the end to hold the additional characters, and you are given the true length
 * of the string.
 *
 * For example:
 * Input: "Mr John Smith", 13
 * Output: "Mr%20John%20Smith"
 */
fun main() {
    println(replaceWhitespace("Mr John Smith    ", 13))
}

private fun replaceWhitespace(input: String, trueLength: Int): String {
    if (input.isEmpty()) {
        return input
    }

    var whiteSpaceCount = 0
    for (i in 0 until trueLength) {
        if (input[i] == ' ') {
            whiteSpaceCount ++
        }
    }
    val trueLengthLength = trueLength + whiteSpaceCount * 2
    val stringArray = CharArray(trueLengthLength + 1)
    var trueLengthIndex = trueLengthLength - 1
    var stringIndex = trueLength - 1
    while(trueLengthIndex >= 0 && stringIndex >= 0) {
        if (input[stringIndex] != ' ') {
            stringArray[trueLengthIndex --] = input[stringIndex --]
        } else {
            stringArray[trueLengthIndex --] = '0'
            stringArray[trueLengthIndex --] = '2'
            stringArray[trueLengthIndex --] = '%'
            stringIndex --
        }
    }
    return stringArray.joinToString("")
}
