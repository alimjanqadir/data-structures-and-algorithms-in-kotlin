package problems

/**
 * Removes the nth node from the end of the linked list
 * Time complexity: O(n) where n is the length of the list
 * Space complexity: O(1) as we only use a few pointers
 */
fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
  // Handle edge cases
  if (head == null || n <= 0) return head

  // Create a dummy node to handle edge cases like removing the first node
  val dummy = ListNode(0).apply { next = head }

  // Use two pointers: fast and slow
  var fast = dummy
  var slow = dummy

  // Move fast pointer n nodes ahead
  repeat(n) {
    fast = fast.next ?: return null // Handle invalid n
  }

  // Move both pointers until fast reaches the end
  // This will position slow at the node before the one to be removed
  while (fast.next != null) {
    fast = fast.next!!
    slow = slow.next!!
  }

  // Remove the nth node by updating the next pointer
  slow.next = slow.next?.next

  return dummy.next
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

/**
 * Tests to verify the solution
 */
