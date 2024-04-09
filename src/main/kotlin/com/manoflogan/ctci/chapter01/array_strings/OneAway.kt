package com.manoflogan.ctci.chapter01.array_strings

import kotlin.math.abs

/**
 * There are three types of edits that can be performed on strings, insert, remove, or replace a
 * character. Check
 *
 * for example pale -> ple (remove "a")
 * for example peal -> peel (replace "a")
 * for example pale -> pales (add "s")
 * for exampel pale -> bake -> false
 */
fun main() {
    arrayOf("pale" to "ple", "peal" to "peel", "pale" to "pales", "pale" to "bake").forEach { pair: Pair<String, String> ->
        println(isOneAway(pair.first, pair.second))
    }
}

private fun isOneAway(firstString: String, secondString: String) : Boolean {
    if (abs(firstString.length - secondString.length) > 1) {
        return false
    }
    var diff = 0
    val firstLength = firstString.length
    val secondLength = secondString.length
    var firstIndex = 0
    var secondIndex = 0
    while (firstIndex < firstLength && secondIndex < secondLength && diff <= 1) {
        if (firstString[firstIndex] == secondString[secondIndex]) {
            firstIndex ++
            secondIndex ++
        } else {
            diff ++
            if (firstString[firstIndex + 1] == secondString[secondIndex]) {
                firstIndex ++
            } else if (firstString[firstIndex] == secondString[secondIndex + 1]) {
                secondIndex ++
            } else {
                firstIndex ++
                secondIndex ++
            }
        }
    }
    return diff <= 1
}
