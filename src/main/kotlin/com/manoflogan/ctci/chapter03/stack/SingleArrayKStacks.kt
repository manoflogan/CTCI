package com.manoflogan.ctci.chapter03.stack

/**
 * Use a single array to support k stack
 */

class KStackArray(
    k: Int,
    maxSize: Int
) {
        var top = Array(k) { -1 }
        val numberArray = Array(maxSize) { -1 }
        var next = Array(maxSize) { it  + 1 }
        var free = 0

    init {
        next[next.lastIndex] = -1
    }

    fun isFull(): Boolean {
        return free == -1
    }

    fun isEmpty(stackNum: Int): Boolean {
        return top[stackNum] == -1
    }

    fun push(value: Int, stackNum: Int) {
        if (isFull()) {
            return
        }
        val i = free
        free = next[i]
        next[i] = top[stackNum]
        top[stackNum] = i
        numberArray[i] = value
    }

    fun pop(stackNum: Int): Int? {
        if (isEmpty(stackNum)) {
            return null
        }
        val i = top[stackNum]
        val value = numberArray[i]
        top[stackNum] = next[i]
        next[i] = free
        return value

    }
}

fun main() {
    val stack = KStackArray(3, 10).apply {
        push(15, 2)
        push(45, 2)

        // Let us put some items in stack number 1
        push(17, 1)
        push(49, 1)
        push(39, 1)

        // Let us put some items in stack number 0
        push(11, 0)
        push(9, 0)
        push(7, 0)
    }
    with(stack) {
        println("Popped element from stack 2 is ${pop(2)}")
        println("Popped element from stack 2 is ${pop(2)}")
        println("Popped element from stack 2 is ${pop(2)}")
        println("Popped element from stack 2 is ${pop(0)}")
        println("Popped element from stack 2 is ${pop(1)}")
    }
}
