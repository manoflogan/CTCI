package com.manoflogan.ctci.chapter03.stack

fun main() {
    val originalStack = java.util.Stack<Int>()
    arrayOf(34, 3, 31, 98, 92, 23).forEach {
        originalStack.push(it)
    }

    println(SortedStack().sort(originalStack))
}


/**
 *
 */
class SortedStack {

    fun sort(originalStack: java.util.Stack<Int>): java.util.Stack<Int> {
        val sortedStack = java.util.Stack<Int>()
        if (originalStack.isEmpty()) {
            return sortedStack
        }
        while (originalStack.isNotEmpty()) {
            val number = originalStack.pop()
            while (sortedStack.isNotEmpty() && number < sortedStack.peek()) {
                originalStack.push(sortedStack.pop())
            }
            sortedStack.push(number)
        }
        return sortedStack
    }
}
