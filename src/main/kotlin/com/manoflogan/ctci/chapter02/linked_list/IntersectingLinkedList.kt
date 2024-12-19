package com.manoflogan.ctci.chapter02.linked_list

import com.manoflogan.ctci.Node

/**
 * Given two singly linked lists, determine if the two lists intersect. If the kth node in one
 * linked list is the same as the jth node in another linked list, then they intersect
 */
fun main() {
    val first = Node(1).apply {
        next = Node(2).apply {
            next = Node(2).apply {
                next = Node(1)
            }
        }
    }

    val second = Node(2).apply {
        next = Node(3).apply {
            next = Node(3).apply {
                next = first.next?.next
            }
        }
    }
    println(doesIntersectingListWithLength(first, second))
    println(doesIntersectingListTwoPoints(first, second))
}

private fun doesIntersectingListTwoPoints(firstNode: Node, secondNode: Node): Boolean {
    var first: Node? = firstNode
    var second: Node? = secondNode
    while (first != second) {
        first = first?.next ?: second
        second = second?.next ?: first
    }
    return first != null
}

private fun doesIntersectingListWithLength(firstNode: Node, secondNode: Node): Boolean {
    val firstLen = length(firstNode)
    val secondLen = length(secondNode)
    return (if (firstLen < secondLen) {
        isIntersecting(secondLen - firstLen, secondNode, firstNode)
    } else {
        isIntersecting(firstLen - secondLen, firstNode, secondNode)
    }
    )
}

private fun length(node: Node): Int {
    var current: Node? = node
    var count = 0
    while (current != null) {
        count ++
        current = current.next
    }
    return count
}

private fun isIntersecting(diff: Int, longerNode: Node, shorterNode: Node): Boolean {
    var first: Node? = longerNode
    var second: Node? = shorterNode
    for (i in 0.until(diff)) {
        first = first?.next
    }
    while (first != null && second != null) {
        if (first == second) {
            return true
        }
        first = first.next
        second = second.next
    }
    return false
}
