package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class MinimizeHammingDistanceAfterSwapOperationsTest {

  @Test
  fun testExample1() {
    // source = [1,2,3,4], target = [2,1,4,5], allowedSwaps = [[0,1],[2,3]]
    // Expected: 1
    val source = intArrayOf(1, 2, 3, 4)
    val target = intArrayOf(2, 1, 4, 5)
    val allowedSwaps = arrayOf(intArrayOf(0, 1), intArrayOf(2, 3))
    assertEquals(1, minimumHammingDistance(source, target, allowedSwaps))
  }

  @Test
  fun testExample2() {
    // source = [1,2,3,4], target = [1,3,2,4], allowedSwaps = []
    // Expected: 2
    val source = intArrayOf(1, 2, 3, 4)
    val target = intArrayOf(1, 3, 2, 4)
    val allowedSwaps = emptyArray<IntArray>()
    assertEquals(2, minimumHammingDistance(source, target, allowedSwaps))
  }

  @Test
  fun testExample3() {
    // source = [5,1,2,4,3], target = [1,5,4,2,3], allowedSwaps = [[0,4],[4,2],[1,3],[1,4]]
    // Expected: 0
    val source = intArrayOf(5, 1, 2, 4, 3)
    val target = intArrayOf(1, 5, 4, 2, 3)
    val allowedSwaps = arrayOf(
      intArrayOf(0, 4),
      intArrayOf(4, 2),
      intArrayOf(1, 3),
      intArrayOf(1, 4)
    )
    assertEquals(0, minimumHammingDistance(source, target, allowedSwaps))
  }

  @Test
  fun testSingleElement() {
    val source = intArrayOf(1)
    val target = intArrayOf(1)
    val allowedSwaps = emptyArray<IntArray>()
    assertEquals(0, minimumHammingDistance(source, target, allowedSwaps))
  }

  @Test
  fun testSingleElementDifferent() {
    val source = intArrayOf(1)
    val target = intArrayOf(2)
    val allowedSwaps = emptyArray<IntArray>()
    assertEquals(1, minimumHammingDistance(source, target, allowedSwaps))
  }

  @Test
  fun testAllConnected() {
    // All indices connected, perfect match possible
    val source = intArrayOf(1, 2, 3)
    val target = intArrayOf(3, 1, 2)
    val allowedSwaps = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
    assertEquals(0, minimumHammingDistance(source, target, allowedSwaps))
  }

  @Test
  fun testNoSwapsAllMatch() {
    val source = intArrayOf(1, 2, 3)
    val target = intArrayOf(1, 2, 3)
    val allowedSwaps = emptyArray<IntArray>()
    assertEquals(0, minimumHammingDistance(source, target, allowedSwaps))
  }

  @Test
  fun testNoSwapsNoMatch() {
    val source = intArrayOf(1, 2, 3)
    val target = intArrayOf(4, 5, 6)
    val allowedSwaps = emptyArray<IntArray>()
    assertEquals(3, minimumHammingDistance(source, target, allowedSwaps))
  }

  @Test
  fun testPartialSwaps() {
    // Component 0-1 can swap, but 2 is isolated
    val source = intArrayOf(1, 2, 3)
    val target = intArrayOf(2, 1, 4)
    val allowedSwaps = arrayOf(intArrayOf(0, 1))
    assertEquals(1, minimumHammingDistance(source, target, allowedSwaps))
  }
}
