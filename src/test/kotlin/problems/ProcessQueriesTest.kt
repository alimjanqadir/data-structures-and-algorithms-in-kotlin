package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class ProcessQueriesTest {
  @Test
  fun testProcessQueries() {
    // Test case 1: Basic test case
    val c1 = 5
    val connections1 = arrayOf(
      intArrayOf(1, 2),
      intArrayOf(1, 3),
      intArrayOf(2, 4),
      intArrayOf(2, 5)
    )
    val queries1 = arrayOf(
      intArrayOf(1, 1),  // Online query for 1, should return 1
      intArrayOf(1, 2),  // Online query for 2, should return 1 or 2
      intArrayOf(2, 2),  // Offline query for 2
      intArrayOf(1, 2),  // Online query for 2 (now offline), should return 1
      intArrayOf(2, 1),  // Offline query for 1
      intArrayOf(1, 1)   // Online query for 1 (now offline), should return 3 or 4 or 5
    )
    val expected1 = intArrayOf(1, 2, 1, 3)
    val result1 = processQueries(c1, connections1, queries1)
    assertContentEquals(expected1, result1)

    // Test case 2: Single component with all nodes connected
    val c2 = 3
    val connections2 = arrayOf(
      intArrayOf(1, 2),
      intArrayOf(2, 3)
    )
    val queries2 = arrayOf(
      intArrayOf(1, 1),  // Should return 1, 2, or 3
      intArrayOf(2, 1),  // Take 1 offline
      intArrayOf(1, 1)   // Should return 2 or 3
    )
    val expected2 = intArrayOf(1, 2)
    val result2 = processQueries(c2, connections2, queries2)
    assert(expected2.size == result2.size) { "Expected size ${expected2.size}, but got ${result2.size}" }

    // Test case 3: No connections
    val c3 = 3
    val connections3 = emptyArray<IntArray>()
    val queries3 = arrayOf(
      intArrayOf(1, 1),  // Only 1 is online
      intArrayOf(1, 2),  // Only 2 is online
      intArrayOf(2, 1),  // Take 1 offline
      intArrayOf(1, 1)   // 1 is offline, should return -1
    )
    val expected3 = intArrayOf(1, 2, -1)
    val result3 = processQueries(c3, connections3, queries3)
    assertContentEquals(expected3, result3)
  }
}
