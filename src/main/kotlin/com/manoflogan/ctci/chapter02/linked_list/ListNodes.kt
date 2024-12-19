package com.manoflogan.ctci.chapter02.linked_list

/**
 *
 */
object ListNodes {

    val listNode = Node(1).apply {
        next = Node(2).apply {
            next = Node(3).apply {
                next = Node(2).apply {
                    next = Node(1).apply {
                        next = Node(4)
                    }
                }
            }
        }
    }
}
