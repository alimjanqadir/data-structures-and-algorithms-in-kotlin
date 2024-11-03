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
fun main() {
  // Test Case 1: [1,4,3,2,5,2], x = 3
  val test1 = createLinkedList(listOf(1, 4, 3, 2, 5, 2))
  println("Test 1 Input: ${printList(test1)}")
  val result1 = partition(test1, 3)
  println("Test 1 Output: ${printList(result1)}")

  // Test Case 2: [2,1], x = 2
  val test2 = createLinkedList(listOf(2, 1))
  println("Test 2 Input: ${printList(test2)}")
  val result2 = partition(test2, 2)
  println("Test 2 Output: ${printList(result2)}")

  // Test Case 3: Empty list
  println("Test 3 Input: empty list")
  val result3 = partition(null, 1)
  println("Test 3 Output: ${printList(result3)}")
}

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