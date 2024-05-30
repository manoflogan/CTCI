package com.manoflogan.ctci.chapter02.linked_list

/**
 * Implementation of [ListNode] implementation
 */
class ListNode(
    val value: Int
) {
    var next: ListNode? = null

    fun display() {
        println(
            buildString {
                append(value)
                var nextNode = next
                while(nextNode != null) {
                    append(" ${nextNode.value}")
                    nextNode = nextNode.next
                }
            }
        )
    }
}
