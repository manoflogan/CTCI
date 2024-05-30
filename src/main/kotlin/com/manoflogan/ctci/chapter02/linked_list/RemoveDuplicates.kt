package com.manoflogan.ctci.chapter02.linked_list

/**
 * 1 -> 2 -> 3 -> 2 - > 1 -> 4
 * 1 -> 2 -> 3 > 4
 * Remove duplicates from an unsorted linked list
 */

/*fun main(args: Array<String>) {

    removeDuplicates(listNode).display()
}*/

fun removeDuplicates(node: ListNode): ListNode {
    val valuesSet = mutableSetOf<Int>()
    var head: ListNode? = node
    val unique = node
    var prev: ListNode? = node
    while(head != null) {
        if (valuesSet.contains(head.value)) {
            prev?.next = head.next
        } else {
            valuesSet.add(head.value)
            prev = head
        }
        head = head.next
    }
    return unique
}
