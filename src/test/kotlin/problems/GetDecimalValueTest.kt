package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GetDecimalValueTest {
  @Test
  fun testGetDecimalValue() {
    val list1 = ListNode(1).apply {
      next = ListNode(0).apply {
        next = ListNode(1)
      }
    }
    assertEquals(5, getDecimalValue(list1))

    val list2 = ListNode(0)
    assertEquals(0, getDecimalValue(list2))

    val list3 = ListNode(1)
    assertEquals(1, getDecimalValue(list3))

    val list4 = ListNode(1).apply {
      next = ListNode(1).apply {
        next = ListNode(1)
      }
    }
    assertEquals(7, getDecimalValue(list4))
  }
}
