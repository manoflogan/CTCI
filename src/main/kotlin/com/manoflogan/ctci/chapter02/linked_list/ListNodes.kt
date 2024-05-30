package com.manoflogan.ctci.chapter02.linked_list

/**
 *
 */
object ListNodes {

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
}
