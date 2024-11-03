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
fun main() {
  // Test case 1: [1,2,3,3,4,4,5] → [1,2,5]
  val test1 = createLinkedList(intArrayOf(1, 2, 3, 3, 4, 4, 5))
  val result1 = deleteDuplicates(test1)
  println("Test 1: ${linkedListToArray(result1).contentToString()}")
  assert(linkedListToArray(result1).contentEquals(intArrayOf(1, 2, 5)))

  // Test case 2: [1,1,1,2,3] → [2,3]
  val test2 = createLinkedList(intArrayOf(1, 1, 1, 2, 3))
  val result2 = deleteDuplicates(test2)
  println("Test 2: ${linkedListToArray(result2).contentToString()}")
  assert(linkedListToArray(result2).contentEquals(intArrayOf(2, 3)))

  // Test case 3: Empty list
  val test3 = createLinkedList(intArrayOf())
  val result3 = deleteDuplicates(test3)
  println("Test 3: ${linkedListToArray(result3).contentToString()}")
  assert(linkedListToArray(result3).contentEquals(intArrayOf()))

  // Test case 4: Single element
  val test4 = createLinkedList(intArrayOf(1))
  val result4 = deleteDuplicates(test4)
  println("Test 4: ${linkedListToArray(result4).contentToString()}")
  assert(linkedListToArray(result4).contentEquals(intArrayOf(1)))

  // Test case 5: All duplicates
  val test5 = createLinkedList(intArrayOf(1, 1, 1))
  val result5 = deleteDuplicates(test5)
  println("Test 5: ${linkedListToArray(result5).contentToString()}")
  assert(linkedListToArray(result5).contentEquals(intArrayOf()))

  println("All test cases passed!")
}