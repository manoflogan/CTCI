package com.manoflogan.ctci.chapter02.linked_list

/**
 * Write code to partition a linked list around "x", such that all nodes less than "x" comes before
 * all nodes greater than or equal to "x".
 */
fun main() {
    val listNode = ListNode(3).apply {
        next = ListNode(5).apply {
            next = ListNode(8).apply {
                next = ListNode(5).apply {
                    next = ListNode(10).apply {
                        next = ListNode(2).apply {
                            next = ListNode(1)
                        }
                    }
                }
            }
        }
    }
    partition(listNode, 5)?.display()
}

fun partition(node: ListNode, k: Int): ListNode? {
    node ?: return null
    var listNode: ListNode? = ListNode(-1)
    var head: ListNode? = node
    val newNode = listNode
    while (head != null) {
        if (head.value < k) {
            listNode?.next = ListNode(head.value)
            listNode = listNode?.next
        }
        head = head.next
    }
    head = node
    while (head != null) {
        if (head.value >= k) {
            listNode?.next = ListNode(head.value)
            listNode = listNode?.next
        }
        head = head.next
    }
    return newNode?.next
}
