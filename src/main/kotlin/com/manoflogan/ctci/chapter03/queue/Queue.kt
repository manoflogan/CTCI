package com.manoflogan.ctci.chapter03.queue

import com.manoflogan.ctci.Node

/**
 *
 */
fun main() {
    val q = Queue()


    // push elements into the queue
    q.push(10)
    q.push(20)

    println("Queue Front: " + q.front?.value)
    println("Queue Rear: " + q.rear?.value)


    // pop elements from the queue
    println(q.pop())
    println(q.pop())


    // push more elements into the queue
    q.push(30)
    q.push(40)
    q.push(50)


    // pop an element from the queue
    println(q.pop())

    println("Queue Front: " + q.front?.value)
    println("Queue Rear: " + q.rear?.value)
}

class Queue {
    var front: Node? = null
    var rear: Node? = null

    fun isEmpty() = front == null && rear == null

    fun peek(): Int? = front?.value

    fun push(value: Int) {
        val item = Node(value)
        if (rear != null) {
            rear?.next = item
        }
        rear = item
        if (front == null) {
            front = rear
        }
    }

    fun pop(): Int? {
        if (front == null) {
            return null
        }
        val value = front!!.value
        front = front?.next
        if (front == null) {
            rear = null
        }
        return value
    }

}
