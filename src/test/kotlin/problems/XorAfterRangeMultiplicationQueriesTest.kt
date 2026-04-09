package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class XorAfterRangeMultiplicationQueriesTest {

  @Test
  fun testExample1() {
    val nums = intArrayOf(1, 1, 1)
    val queries = arrayOf(intArrayOf(0, 2, 1, 4))
    // After query: [4, 4, 4], XOR = 4 xor 4 xor 4 = 4
    assertEquals(4, xorAfterQueries(nums, queries))
  }

  @Test
  fun testExample2() {
    val nums = intArrayOf(2, 3, 1, 5, 4)
    val queries = arrayOf(intArrayOf(1, 4, 2, 3), intArrayOf(0, 2, 1, 2))
    // First query multiplies indices 1, 3 by 3: [2, 9, 1, 15, 4]
    // Second query multiplies indices 0, 1, 2 by 2: [4, 18, 2, 15, 4]
    // XOR = 4 xor 18 xor 2 xor 15 xor 4 = 31
    assertEquals(31, xorAfterQueries(nums, queries))
  }

  @Test
  fun testSingleElement() {
    val nums = intArrayOf(5)
    val queries = arrayOf(intArrayOf(0, 0, 1, 7))
    // After query: [35], XOR = 35
    assertEquals(35, xorAfterQueries(nums, queries))
  }

  @Test
  fun testEmptyQueries() {
    val nums = intArrayOf(1, 2, 3)
    val queries = emptyArray<IntArray>()
    // No changes, XOR = 1 xor 2 xor 3 = 0
    assertEquals(0, xorAfterQueries(nums, queries))
  }

  @Test
  fun testLargeStep() {
    val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val queries = arrayOf(intArrayOf(0, 9, 5, 2))
    // After query: indices 0, 5 are multiplied by 2
    // [2, 2, 3, 4, 5, 12, 7, 8, 9, 10]
    val result = 2 xor 2 xor 3 xor 4 xor 5 xor 12 xor 7 xor 8 xor 9 xor 10
    assertEquals(result, xorAfterQueries(nums.copyOf(), queries))
  }

  @Test
  fun testModuloOperation() {
    val nums = intArrayOf(1_000_000_000)
    val queries = arrayOf(intArrayOf(0, 0, 1, 1_000_000_000))
    // 10^9 ≡ -7 (mod 10^9+7), so (-7) * (-7) = 49
    val expected = 49
    assertEquals(expected, xorAfterQueries(nums, queries))
  }

  @Test
  fun testMultipleQueriesOverlap() {
    val nums = intArrayOf(1, 1, 1, 1)
    val queries = arrayOf(
      intArrayOf(0, 3, 1, 2),
      intArrayOf(0, 3, 2, 3)
    )
    // After first query: [2, 2, 2, 2]
    // After second query (indices 0, 2 multiplied by 3): [6, 2, 6, 2]
    // XOR = 6 xor 2 xor 6 xor 2 = 0
    assertEquals(0, xorAfterQueries(nums, queries))
  }
}
