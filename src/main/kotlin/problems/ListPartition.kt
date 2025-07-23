package problems

/**
 * Partitions a linked list around value x such that all nodes less than x come before nodes greater
 * than or equal to x, while preserving the relative ordering within each partition.
 *
 * Time Complexity: O(n) where n is the number of nodes in the list
 * Space Complexity: O(1) as we only use a constant amount of extra space
 *
 * @param head The head of the input linked list
 * @param x The partition value
 * @return The head of the partitioned linked list
 */
fun partition(head: ListNode?, x: Int): ListNode? {
  // Edge case: empty list or single node
  if (head?.next == null) return head

  // Create dummy heads for two separate lists
  val beforeDummy = ListNode(0)  // For nodes < x
  val afterDummy = ListNode(0)   // For nodes >= x

  // Initialize pointers for both lists
  var beforeTail = beforeDummy
  var afterTail = afterDummy

  // Traverse original list and distribute nodes
  var current = head
  while (current != null) {
    if (current.`val` < x) {
      // Add to before list
      beforeTail.next = current
      beforeTail = current
    } else {
      // Add to after list
      afterTail.next = current
      afterTail = current
    }
    current = current.next
  }

  // Connect the two lists
  beforeTail.next = afterDummy.next
  afterTail.next = null

  return beforeDummy.next
}

/**
 * Test cases
 */
// Helper function to create a linked list from a list of integers
fun createLinkedList(values: List<Int>): ListNode? {
  if (values.isEmpty()) return null

  val dummy = ListNode(0)
  var current = dummy

  for (value in values) {
    current.next = ListNode(value)
    current = current.next!!
  }

  return dummy.next
}

// Helper function to print a linked list
fun printList(head: ListNode?): String {
  val result = mutableListOf<Int>()
  var current = head

  while (current != null) {
    result.add(current.`val`)
    current = current.next
  }

  return result.toString()
}
