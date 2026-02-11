package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class AddTwoNumbersTest {
    
  // Helper function to convert List to ListNode
  private fun listToNode(nums: List<Int>): ListNode? {
    if (nums.isEmpty()) return null
    val dummyHead = ListNode(0)
    var current = dummyHead
    for (num in nums) {
      current.next = ListNode(num)
      current = current.next!!
    }
    return dummyHead.next
  }

  // Helper function to convert ListNode to List
  private fun nodeToList(head: ListNode?): List<Int> {
    val result = mutableListOf<Int>()
    var current = head
    while (current != null) {
      result.add(current.`val`)
      current = current.next
    }
    return result
  }

  @Test
  fun testAddTwoNumbers() {
    // Test case 1: Basic addition (342 + 465 = 807)
    val l1 = listToNode(listOf(2, 4, 3))
    val l2 = listToNode(listOf(5, 6, 4))
    val result1 = addTwoNumbers(l1, l2)
    assertEquals(listOf(7, 0, 8), nodeToList(result1))

    // Test case 2: Different lengths (9999999 + 9999 = 10009998)
    val l3 = listToNode(listOf(9, 9, 9, 9, 9, 9, 9))
    val l4 = listToNode(listOf(9, 9, 9, 9))
    val result2 = addTwoNumbers(l3, l4)
    assertEquals(listOf(8, 9, 9, 9, 0, 0, 0, 1), nodeToList(result2))

    // Test case 3: One list is empty (0 + 123 = 123)
    val l5 = listToNode(emptyList())
    val l6 = listToNode(listOf(3, 2, 1))
    val result3 = addTwoNumbers(l5, l6)
    assertEquals(listOf(3, 2, 1), nodeToList(result3))

    // Test case 4: Both lists are empty (0 + 0 = 0)
    val l7 = listToNode(emptyList())
    val l8 = listToNode(emptyList())
    val result4 = addTwoNumbers(l7, l8)
    assertEquals(emptyList<Int>(), nodeToList(result4))

    // Test case 5: Carry at the end (5 + 5 = 10)
    val l9 = listToNode(listOf(5))
    val l10 = listToNode(listOf(5))
    val result5 = addTwoNumbers(l9, l10)
    assertEquals(listOf(0, 1), nodeToList(result5))
  }
}
