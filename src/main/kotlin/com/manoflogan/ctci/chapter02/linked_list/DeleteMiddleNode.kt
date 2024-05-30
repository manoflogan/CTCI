package com.manoflogan.ctci.chapter02.linked_list

import com.manoflogan.ctci.chapter02.linked_list.ListNodes.listNode

/**
 * Implement an algorithm to delete a node in the middle of a singly linked list, given only access
 * to the node.
 */
/*fun main() {
    deleteMiddleNode(listNode)?.display()
}*/

private fun deleteMiddleNode(node: ListNode): ListNode? {
    var slow: ListNode? = node
    var fast: ListNode? = node
    var unique = slow
    while(fast?.next?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }
    slow?.next = slow?.next?.next
    return unique
}
