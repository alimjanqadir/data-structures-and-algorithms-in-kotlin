package problems

/**
 * Removes all nodes that have duplicate values from a sorted linked list
 * Time Complexity: O(n) where n is the number of nodes
 * Space Complexity: O(1) as we only use a few pointers
 */
fun deleteDuplicates(head: ListNode?): ListNode? {
  // Handle empty list or single node
  if (head?.next == null) return head

  // Create a dummy node to handle cases where head needs to be removed
  val dummy = ListNode(0).apply { next = head }
  var prev = dummy
  var current = head

  while (current != null) {
    // Check if current node is the start of duplicates
    if (current.next != null && current.`val` == current.next?.`val`) {
      // Skip all nodes with the same value
      val duplicateValue = current.`val`
      while (current != null && current.`val` == duplicateValue) {
        current = current.next
      }
      // Connect previous node to the first non-duplicate node
      prev.next = current
    } else {
      // Move to next node if no duplicates found
      prev = current
      current = current.next
    }
  }

  return dummy.next
}

/**
 * Helper function to create a linked list from an array for testing
 */
private  fun createLinkedList(arr: IntArray): ListNode? {
  if (arr.isEmpty()) return null

  val head = ListNode(arr[0])
  var current = head

  for (i in 1 until arr.size) {
    current.next = ListNode(arr[i])
    current = current.next!!
  }

  return head
}

/**
 * Helper function to convert a linked list to array for testing
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
 * Test cases
 */
