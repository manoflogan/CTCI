package com.manoflogan.ctci.chapter02.linked_list

/**
 * Write code to partition a linked list around "x", such that all nodes less than "x" comes before
 * all nodes greater than or equal to "x".
 */
fun main() {
    val listNode = Node(3).apply {
        next = Node(5).apply {
            next = Node(8).apply {
                next = Node(5).apply {
                    next = Node(10).apply {
                        next = Node(2).apply {
                            next = Node(1)
                        }
                    }
                }
            }
        }
    }
    partition(listNode, 5)?.display()
}

fun partition(node: Node, k: Int): Node? {
    node ?: return null
    var listNode: Node? = Node(-1)
    var head: Node? = node
    val newNode = listNode
    while (head != null) {
        if (head.value < k) {
            listNode?.next = Node(head.value)
            listNode = listNode?.next
        }
        head = head.next
    }
    head = node
    while (head != null) {
        if (head.value >= k) {
            listNode?.next = Node(head.value)
            listNode = listNode?.next
        }
        head = head.next
    }
    return newNode?.next
}
