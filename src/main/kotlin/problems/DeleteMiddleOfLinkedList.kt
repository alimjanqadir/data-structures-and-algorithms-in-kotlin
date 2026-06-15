package problems

/**
 * Deletes the middle node of a linked list
 * Time complexity: O(n) where n is the length of the list
 * Space complexity: O(1) as we only use a few pointers
 */
fun deleteMiddle(head: ListNode?): ListNode? {
  if (head?.next == null) {
    return null
  }

  var slowPointer = head
  var fastPointer = head
  var previousNode: ListNode? = null

  while (fastPointer != null && fastPointer.next != null) {
    previousNode = slowPointer
    slowPointer = slowPointer?.next
    fastPointer = fastPointer.next?.next
  }

  previousNode?.next = slowPointer?.next

  return head
}

/**
 * Helper function to create a linked list from an array
 */
private fun createLinkedList(values: IntArray): ListNode? {
  if (values.isEmpty()) return null

  val dummy = ListNode(0)
  var current = dummy

  values.forEach { value ->
    current.next = ListNode(value)
    current = current.next!!
  }

  return dummy.next
}

/**
 * Helper function to convert a linked list to an array for testing
 */
private fun linkedListToArray(head: ListNode?): IntArray {
  val result = mutableListOf<Int>()
  var current = head

  while (current != null) {
    result.add(current.`val`)
    current = current.next
  }

  return result.toIntArray()
}
