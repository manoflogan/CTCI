package com.manoflogan.ctci.chapter02.linked_list

/**
 * Implementation of [Node] implementation
 */
class Node(
    val value: Int
) {
    var next: Node? = null

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