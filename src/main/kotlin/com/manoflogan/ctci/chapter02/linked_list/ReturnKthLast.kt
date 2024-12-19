package com.manoflogan.ctci.chapter02.linked_list

/**
 * Implement an algorithm to find the kth to last element of a singly linked list.
 */

/**fun main() {
    val listNode = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(2).apply {
                    next = ListNode(1).apply {
                        next = ListNode(4)
                    }
                }
            }
        }
    }
   // findKthLinkedList(listNode, 2)?.display()
    findKthLinkedListRecursive(listNode, 2)
    kNode?.display()
} */

private fun findKthLinkedList(node: Node, k: Int): Node? {
    var head: Node? = node
    for (i in 0 until k) {
        head = head?.next
    }
    head ?: return null
    var trailing: Node? = node
    while (head != null) {
        head = head.next
        trailing = trailing?.next
    }
    return trailing
}

var count = 0
var kNode: Node? = null
private fun findKthLinkedListRecursive(node: Node?, k: Int) {
    node ?: return
    findKthLinkedListRecursive(node.next, k)
    count ++
    if (count == k) {
        kNode = node
    }
}
