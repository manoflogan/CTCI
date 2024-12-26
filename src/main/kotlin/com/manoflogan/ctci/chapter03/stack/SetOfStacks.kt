package com.manoflogan.ctci.chapter03.stack

import java.util.PriorityQueue
import kotlin.system.exitProcess

fun main() {
    /**
     * ["DinnerPlates","push","push","push","push","push","popAtStack","push","push","popAtStack","popAtStack","pop","pop","pop","pop","pop"]
     * [[2],[1],[2],[3],[4],[5],[0],[20],[21],[0],[2],[],[],[],[],[]]
     */
    val setOfStacks = SetOfStacks(2)
    with(setOfStacks) {
        push(1)
        push(2)
        push(3)
        push(4)
        push(5)
        println(popAtStack(0))
        push(20)
        push(21)
        println(popAtStack(0))
        println(popAtStack(2))
        println(pop())
        println(pop())
        println(pop())
        println(pop())
        println(pop())
    }
}
/**
 *
 */
class SetOfStacks(
    private val capacity: Int
) {

    private val stackList = mutableListOf<java.util.Stack<Int>>()

    private val priorityQueue = java.util.PriorityQueue<Int>()

    fun push(value: Int) {
        if (priorityQueue.isEmpty()) {
            java.util.Stack<Int>().apply {
                push(value)
                stackList.add(this)
            }
            if (capacity > 1) {
                priorityQueue.offer(stackList.lastIndex) // Index of first stack index
            }
        } else {
            val stack = stackList.getOrNull(priorityQueue.peek()!!) ?: return
            stack.push(value)
            if (stack.size == capacity) {
                priorityQueue.poll()
            }
        }

    }

    fun pop(): Int {
        for (index in (stackList.size - 1) downTo 0) {
            val stack = stackList.getOrNull(index) ?: continue
            if (stack.isEmpty()) {
                stackList.removeAt(index)
                priorityQueue.remove(index)
            }
        }
        return popAtStack(stackList.lastIndex)
    }

    fun popAtStack(index: Int): Int {
        val stack = stackList.getOrNull(index) ?: return -1
        if (stack.isEmpty()) {
            return -1
        }
        if (stack.size == capacity) {
            priorityQueue.offer(index)
        }
        return stack.pop()
    }

}
