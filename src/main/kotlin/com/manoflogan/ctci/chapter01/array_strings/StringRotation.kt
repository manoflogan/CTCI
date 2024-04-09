package com.manoflogan.ctci.chapter01.array_strings

/**
 *
 */
fun main() {
    println(isStringRotated("erbottlewat", "waterbottle"))
}

fun isStringRotated(rotatedString: String, string: String): Boolean {
    val concatString = buildString {
        append(rotatedString)
        append(rotatedString)
    }
    return concatString.indexOf(string) > -1
}
