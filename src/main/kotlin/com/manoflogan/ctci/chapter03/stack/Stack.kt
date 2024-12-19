package com.manoflogan.ctci.chapter03.stack

import com.manoflogan.ctci.Node

fun main() {
    val stack = Stack().apply {
        push(3)
        push(2)
        push(7)
        push(1)
    }
    println(stack.peek())
    println(stack.pop())
    println(stack.pop())
    stack.push(4)
    println(stack.isEmpty())
    println(stack.peek())

}

/**
 *
 */
class Stack {

    private var top: Node? = null

    fun pop(): Int? {
        val num = top?.value
        top = top?.next
        return num
    }

    fun push(number: Int) {
        val item = Node(number).apply {
            next = top
        }
        top = item
    }

    fun peek(): Int? {
        return top?.value
    }

    fun isEmpty(): Boolean {
        return top == null
    }
}
