package com.manoflogan.ctci.chapter02.linked_list

/**
 * Given the head of a singly linked list, return true if it is a
 * palindrome
 *  or false otherwise.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,2,1]
 * Output: true
 * Example 2:
 *
 *
 * Input: head = [1,2]
 * Output: false
 */

fun main() {
    val nodes = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(2).apply {
                next = ListNode(1)
            }
        }
    }
    println(isPalindrome(nodes))
}

fun isPalindrome(head: ListNode?): Boolean {
    head ?: return true
    val reverseList = reverseNode(endOfFirstHalf(head)?.next)
    var first = head
    var second = reverseList
    while (first != null && second != null) {
        if (first.value != second.value) {
            return false
        }
        first = first.next
        second = second.next
    }
    return true
}

private fun endOfFirstHalf(head: ListNode?): ListNode? {
    var fast = head
    var slow = head
    while (fast?.next?.next != null) {
        fast = fast.next?.next
        slow = slow?.next
    }
    return slow?.next
}

private fun reverseNode(listNode: ListNode?): ListNode? {
    var current = listNode
    var next: ListNode? = null
    var prev: ListNode? = null
    while (current != null) {
        next = current.next
        current.next = prev
        prev = current
        current = next
    }
    return prev
}



