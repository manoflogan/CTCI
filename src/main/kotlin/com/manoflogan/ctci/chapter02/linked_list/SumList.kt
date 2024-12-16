package com.manoflogan.ctci.chapter02.linked_list

/**
 * You have two numbers represented by a linked list, where each node contains a single digit.
 */
fun main() {
  val first = ListNode(7).apply {
      next = ListNode(1).apply {
          next = ListNode(6)
      }
  }
  val second = ListNode(5).apply {
      next = ListNode(9).apply {
          next = ListNode(2)
      }
  }
    // sumListReverse(first, second)?.display()
    sumListForward(first, second)?.display()
}

/**
 * The digits are in reverse order, such that 1st digit is at the head of the list. Write a
 *  * function that adds the two numbers and returns the sum as a linked list.
 */
private fun sumListReverse(firstNode: ListNode, secondNode: ListNode): ListNode? {
    val sum = ListNode(-1)
    var first: ListNode? = firstNode
    var second: ListNode? = secondNode
    var carry = 0
    var head: ListNode? = sum
    while(first != null ||second != null) {
        val firstValue = first?.value ?: 0
        val secondValue = second?.value ?: 0
        val sumDigit = (firstValue + secondValue + carry)
        val digit = sumDigit.mod(10)
        carry = sumDigit / 10
        head?.next = ListNode(digit)
        head = head?.next
        first = first?.next
        second = second?.next
    }
    if (carry > 0) {
        head?.next = ListNode(carry)
    }
    return sum.next
}

/**
 * The digits are in forward order, such that 1st digit is at the back of the list. Write a
 *  * function that adds the two numbers and returns the sum as a linked list.
 */
private fun sumListForward(firstNode: ListNode, secondNode: ListNode): ListNode? {
    firstNode.display()
    var first: ListNode = reverseLinkedList(firstNode).also {
        it.display()
    }
    secondNode.display()
    var second: ListNode = reverseLinkedList(secondNode).also {
        it.display()
    }
    return sumListReverse(first, second)
}

// prev = C -> B -> A
private fun reverseLinkedList(node: ListNode): ListNode {
    var prev: ListNode? = null
    var current: ListNode? = node // A
    // A -> B -> C
    while (current != null) {
        val next = current.next // B
        current.next = prev  // B -> A -> null
        prev = current // B -> A ->
        current = next // B
    }
    return prev!!
}
