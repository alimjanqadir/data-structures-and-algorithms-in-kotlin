package problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindClosestNodeToGivenTwoNodesTest {
  @Test
  fun testExample1() {
    val edges = intArrayOf(2, 2, 3, -1)
    assertEquals(2, closestMeetingNode(edges, 0, 1))
  }

  @Test
  fun testExample2() {
    val edges = intArrayOf(1, 2, -1)
    assertEquals(2, closestMeetingNode(edges, 0, 2))
  }

  @Test
  fun testNoMeetingNode() {
    val edges = intArrayOf(1, -1, -1, 2, 3)
    assertEquals(-1, closestMeetingNode(edges, 0, 4))
  }
}
