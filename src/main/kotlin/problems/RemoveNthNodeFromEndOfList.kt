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
fun main() {
  // Test case 1: [1,2,3,4,5], n=2 -> [1,2,3,5]
  val test1 = createLinkedList(intArrayOf(1, 2, 3, 4, 5))
  val result1 = removeNthFromEnd(test1, 2)
  println("Test 1: ${linkedListToArray(result1).contentToString()}")
  assert(linkedListToArray(result1).contentEquals(intArrayOf(1, 2, 3, 5)))

  // Test case 2: [1], n=1 -> []
  val test2 = createLinkedList(intArrayOf(1))
  val result2 = removeNthFromEnd(test2, 1)
  println("Test 2: ${linkedListToArray(result2).contentToString()}")
  assert(linkedListToArray(result2).contentEquals(intArrayOf()))

  // Test case 3: [1,2], n=1 -> [1]
  val test3 = createLinkedList(intArrayOf(1, 2))
  val result3 = removeNthFromEnd(test3, 1)
  println("Test 3: ${linkedListToArray(result3).contentToString()}")
  assert(linkedListToArray(result3).contentEquals(intArrayOf(1)))

  println("All tests passed!")
}