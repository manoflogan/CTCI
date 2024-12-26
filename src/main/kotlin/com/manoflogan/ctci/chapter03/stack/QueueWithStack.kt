package com.manoflogan.ctci.chapter03.stack

/**
 * Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
 *
 * Implement the MyQueue class:
 *
 * void push(int x) Pushes element x to the back of the queue.
 * int pop() Removes the element from the front of the queue and returns it.
 * int peek() Returns the element at the front of the queue.
 * boolean empty() Returns true if the queue is empty, false otherwise.
 */
class QueueWithStack {

    private val firstStack = java.util.Stack<Int>()
    private val secondStack = java.util.Stack<Int>()

    fun push(value: Int) {
        firstStack.push(value)
    }

    fun pop(): Int? {
        if (isEmpty()) {
            return null
        }
        return if (!secondStack.isEmpty()) {
            secondStack.pop()
        } else {
            moveToSecondStack()
            secondStack.pop()
        }
    }

    fun peek(): Int? {
        if (secondStack.isNotEmpty()) {
            return secondStack.peek()
        }
        moveToSecondStack()
        return secondStack.peek()

    }

    private fun moveToSecondStack() {
        while (firstStack.isNotEmpty()) {
            secondStack.push(firstStack.pop())
        }
    }

    private fun isEmpty() = firstStack.isEmpty() && secondStack.isEmpty()
}
