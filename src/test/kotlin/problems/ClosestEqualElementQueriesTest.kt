package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class ClosestEqualElementQueriesTest {

  @Test
  fun testExample1() {
    // nums = [1,3,1,4,1], queries = [0,3]
    // Query 0: value 1 at indices [0,2,4], distances are min(2,3)=2 and min(4,1)=1, result=1
    // Query 3: value 4 at indices [3], only one occurrence, return -1
    val nums = intArrayOf(1, 3, 1, 4, 1)
    val queries = intArrayOf(0, 3)
    val expected = listOf(1, -1)
    assertEquals(expected, closestEqualElementQueries(nums, queries))
  }

  @Test
  fun testExample2() {
    // nums = [1,2,3,4,5], queries = [0,1,2,3,4]
    // All values appear once, all return -1
    val nums = intArrayOf(1, 2, 3, 4, 5)
    val queries = intArrayOf(0, 1, 2, 3, 4)
    val expected = listOf(-1, -1, -1, -1, -1)
    assertEquals(expected, closestEqualElementQueries(nums, queries))
  }

  @Test
  fun testCircularWrapAround() {
    // nums = [1,2,1], queries = [0,2]
    // Query 0: value 1 at indices [0,2], distance = min(2, 3-2) = 1
    // Query 2: value 1 at indices [0,2], distance = min(2, 3-2) = 1
    val nums = intArrayOf(1, 2, 1)
    val queries = intArrayOf(0, 2)
    val expected = listOf(1, 1)
    assertEquals(expected, closestEqualElementQueries(nums, queries))
  }

  @Test
  fun testMultipleOccurrences() {
    // nums = [1,1,1,1], queries = [0,1,2,3]
    // All queries for value 1, closest neighbor is adjacent (distance 1)
    val nums = intArrayOf(1, 1, 1, 1)
    val queries = intArrayOf(0, 1, 2, 3)
    val expected = listOf(1, 1, 1, 1)
    assertEquals(expected, closestEqualElementQueries(nums, queries))
  }

  @Test
  fun testMixedValues() {
    // nums = [1,3,1,4,1,3,2], queries = [0,1,2,3,4,5,6]
    // 1 -> [0,2,4], 3 -> [1,5], 4 -> [3], 2 -> [6]
    val nums = intArrayOf(1, 3, 1, 4, 1, 3, 2)
    val queries = intArrayOf(0, 1, 2, 3, 4, 5, 6)
    // Query 0 (val 1): neighbors are 4 and 2, distances min(4,3)=3 and min(2,5)=2, result=2
    // Query 1 (val 3): neighbors are 5, distance min(4,3)=3
    // Query 2 (val 1): neighbors are 0 and 4, distances min(2,5)=2 and min(2,5)=2, result=2
    // Query 3 (val 4): only one, -1
    // Query 4 (val 1): neighbors are 2 and 0, distances min(2,5)=2 and min(4,3)=3, result=2
    // Query 5 (val 3): neighbors are 1, distance min(4,3)=3
    // Query 6 (val 2): only one, -1
    val expected = listOf(2, 3, 2, -1, 2, 3, -1)
    assertEquals(expected, closestEqualElementQueries(nums, queries))
  }

  @Test
  fun testLargeArray() {
    // Test with larger array to verify binary search works correctly
    // nums = [1,2,1,2,1,2,1,2], queries = [0,3,6]
    // 1 -> [0,2,4,6], 2 -> [1,3,5,7]
    val nums = intArrayOf(1, 2, 1, 2, 1, 2, 1, 2)
    val queries = intArrayOf(0, 3, 6)
    // Query 0 (val 1): neighbors are 6 and 2, distances min(2,6) and min(2,6), result=2
    // Query 3 (val 2): neighbors are 1 and 5, distances min(2,6) and min(2,6), result=2
    // Query 6 (val 1): neighbors are 4 and 0, distances min(2,6) and min(6,2)=2, result=2
    val expected = listOf(2, 2, 2)
    assertEquals(expected, closestEqualElementQueries(nums, queries))
  }

  @Test
  fun testSingleElement() {
    val nums = intArrayOf(1)
    val queries = intArrayOf(0)
    val expected = listOf(-1)
    assertEquals(expected, closestEqualElementQueries(nums, queries))
  }

  @Test
  fun testTwoEqualElements() {
    val nums = intArrayOf(5, 5)
    val queries = intArrayOf(0, 1)
    val expected = listOf(1, 1)
    assertEquals(expected, closestEqualElementQueries(nums, queries))
  }

  @Test
  fun testCircularDistanceAtEdges() {
    // nums = [1,2,3,1], query at index 0 and 3 for value 1
    // distance = min(3, 4-3) = 1
    val nums = intArrayOf(1, 2, 3, 1)
    val queries = intArrayOf(0, 3)
    val expected = listOf(1, 1)
    assertEquals(expected, closestEqualElementQueries(nums, queries))
  }
}
