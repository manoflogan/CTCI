package com.manoflogan.ctci.chapter02.linked_list

/**
 * Given a linked list which might contain a loop, implement an algorithm that returns the node
 * at the beginning of the loop.
 */
fun main() {
    val first = Node(1).apply {
        next = Node(2).apply {
            next = Node(2)
        }
    }
    first.next?.next?.next = first.next
    println(doesLoopExist(first))
}

private fun doesLoopExist(listNode: Node): Boolean {
    var fast: Node? = listNode
    var slow: Node? = listNode
    while (fast?.next != null) {
        fast = fast.next?.next
        slow = slow?.next
        if (fast == slow) {
            return true
        }
    }
    return false
}
