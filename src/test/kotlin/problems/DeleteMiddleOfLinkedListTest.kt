package problems

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class DeleteMiddleOfLinkedListTest {
  @Test
  fun example1() {
    val head = createLinkedList(intArrayOf(1, 3, 4, 7, 1, 2, 6))
    val result = deleteMiddle(head)
    val expected = intArrayOf(1, 3, 4, 1, 2, 6)
    assertArrayEquals(expected, linkedListToArray(result))
  }

  @Test
  fun example2() {
    val head = createLinkedList(intArrayOf(1, 2, 3, 4))
    val result = deleteMiddle(head)
    val expected = intArrayOf(1, 2, 4)
    assertArrayEquals(expected, linkedListToArray(result))
  }

  @Test
  fun example3() {
    val head = createLinkedList(intArrayOf(2, 1))
    val result = deleteMiddle(head)
    val expected = intArrayOf(2)
    assertArrayEquals(expected, linkedListToArray(result))
  }

  @Test
  fun singleNode() {
    val head = createLinkedList(intArrayOf(1))
    val result = deleteMiddle(head)
    assertArrayEquals(intArrayOf(), linkedListToArray(result))
  }

  @Test
  fun threeNodes() {
    val head = createLinkedList(intArrayOf(1, 2, 3))
    val result = deleteMiddle(head)
    val expected = intArrayOf(1, 3)
    assertArrayEquals(expected, linkedListToArray(result))
  }

  @Test
  fun fiveNodes() {
    val head = createLinkedList(intArrayOf(1, 2, 3, 4, 5))
    val result = deleteMiddle(head)
    val expected = intArrayOf(1, 2, 4, 5)
    assertArrayEquals(expected, linkedListToArray(result))
  }
}
