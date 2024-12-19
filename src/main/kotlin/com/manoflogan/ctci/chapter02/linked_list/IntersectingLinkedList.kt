package com.manoflogan.ctci.chapter02.linked_list

/**
 * Given two singly linked lists, determine if the two lists intersect. If the kth node in one
 * linked list is the same as the jth node in another linked list, then they intersect
 */
fun main() {
    val first = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(2).apply {
                next = ListNode(1)
            }
        }
    }

    val second = ListNode(2).apply {
        next = ListNode(3).apply {
            next = ListNode(3).apply {
                next = first.next?.next
            }
        }
    }
    println(doesIntersectingListWithLength(first, second))
    println(doesIntersectingListTwoPoints(first, second))
}

private fun doesIntersectingListTwoPoints(firstNode: ListNode, secondNode: ListNode): Boolean {
    var first: ListNode? = firstNode
    var second: ListNode? = secondNode
    while (first != second) {
        first = first?.next ?: second
        second = second?.next ?: first
    }
    return first != null
}

private fun doesIntersectingListWithLength(firstNode: ListNode, secondNode: ListNode): Boolean {
    val firstLen = length(firstNode)
    val secondLen = length(secondNode)
    return (if (firstLen < secondLen) {
        isIntersecting(secondLen - firstLen, secondNode, firstNode)
    } else {
        isIntersecting(firstLen - secondLen, firstNode, secondNode)
    }
    )
}

private fun length(node: ListNode): Int {
    var current: ListNode? = node
    var count = 0
    while (current != null) {
        count ++
        current = current.next
    }
    return count
}

private fun isIntersecting(diff: Int, longerNode: ListNode, shorterNode: ListNode): Boolean {
    var first: ListNode? = longerNode
    var second: ListNode? = shorterNode
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
