package com.manoflogan.ctci.chapter03.stack


/**
 * How would you design a stack which in addition to push and pop, has a minimum function that
 * returns a minimum element. All operations must have a constant O(1) time
 */
class MinStack {

    private val stack = java.util.Stack<Int>()

    private val minStack = java.util.Stack<Int>()

    fun push(`val`: Int) {
        stack.push(`val`)
        if (minStack.isEmpty() || `val` <= minStack.peek()) {
            minStack.push(`val`)
        }
    }

    fun pop() {
        val number = stack.pop()
        if (number == minStack.peek()) {
            minStack.pop()
        }
    }

    fun top(): Int {
        return stack.peek()!!
    }

    fun getMin(): Int {
        return minStack.peek()!!
    }
}

fun main() {
    val minStack =  MinStack()
    minStack.push(2)
    minStack.push(0)
    minStack.push(3)
    minStack.push(0)
    println(minStack.getMin()) // return -3
    minStack.pop()
    println(minStack.top())    // return 0
    println(minStack.getMin()) // return -2

}
