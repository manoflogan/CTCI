package com.manoflogan.ctci.chapter02.linked_list

/**
 * You have two numbers represented by a linked list, where each node contains a single digit.
 */
fun main() {
  val first = Node(7).apply {
      next = Node(1).apply {
          next = Node(6)
      }
  }
  val second = Node(5).apply {
      next = Node(9).apply {
          next = Node(2)
      }
  }
    // sumListReverse(first, second)?.display()
    sumListForward(first, second)?.display()
}

/**
 * The digits are in reverse order, such that 1st digit is at the head of the list. Write a
 *  * function that adds the two numbers and returns the sum as a linked list.
 */
private fun sumListReverse(firstNode: Node, secondNode: Node): Node? {
    val sum = Node(-1)
    var first: Node? = firstNode
    var second: Node? = secondNode
    var carry = 0
    var head: Node? = sum
    while(first != null ||second != null) {
        val firstValue = first?.value ?: 0
        val secondValue = second?.value ?: 0
        val sumDigit = (firstValue + secondValue + carry)
        val digit = sumDigit.mod(10)
        carry = sumDigit / 10
        head?.next = Node(digit)
        head = head?.next
        first = first?.next
        second = second?.next
    }
    if (carry > 0) {
        head?.next = Node(carry)
    }
    return sum.next
}

/**
 * The digits are in forward order, such that 1st digit is at the back of the list. Write a
 *  * function that adds the two numbers and returns the sum as a linked list.
 */
private fun sumListForward(firstNode: Node, secondNode: Node): Node? {
    firstNode.display()
    var first: Node = reverseLinkedList(firstNode).also {
        it.display()
    }
    secondNode.display()
    var second: Node = reverseLinkedList(secondNode).also {
        it.display()
    }
    return sumListReverse(first, second)
}

// prev = C -> B -> A
private fun reverseLinkedList(node: Node): Node {
    var prev: Node? = null
    var current: Node? = node // A
    // A -> B -> C
    while (current != null) {
        val next = current.next // B
        current.next = prev  // B -> A -> null
        prev = current // B -> A ->
        current = next // B
    }
    return prev!!
}
