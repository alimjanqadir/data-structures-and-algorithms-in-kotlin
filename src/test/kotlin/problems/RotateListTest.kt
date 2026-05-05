package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class RotateListTest {

  private fun listToNode(nums: List<Int>): ListNode? {
    if (nums.isEmpty()) return null

    val dummy = ListNode(0)
    var current = dummy

    for (num in nums) {
      current.next = ListNode(num)
      current = current.next!!
    }

    return dummy.next
  }

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
  fun rotatesRightByK() {
    val input = listToNode(listOf(1, 2, 3, 4, 5))

    val result = rotateRight(input, 2)

    assertEquals(listOf(4, 5, 1, 2, 3), nodeToList(result))
  }

  @Test
  fun handlesLargeKWithModulo() {
    val input = listToNode(listOf(0, 1, 2))

    val result = rotateRight(input, 4)

    assertEquals(listOf(2, 0, 1), nodeToList(result))
  }

  @Test
  fun returnsSameListWhenKIsZero() {
    val input = listToNode(listOf(1, 2))

    val result = rotateRight(input, 0)

    assertEquals(listOf(1, 2), nodeToList(result))
  }

  @Test
  fun handlesEmptyList() {
    val result = rotateRight(null, 99)

    assertEquals(emptyList(), nodeToList(result))
  }
}
