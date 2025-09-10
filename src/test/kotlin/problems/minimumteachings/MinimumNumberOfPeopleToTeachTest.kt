package problems.minimumteachings

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MinimumNumberOfPeopleToTeachTest {
  @Test
  fun testExamples() {
    val solution = Solution()
    assertEquals(
      1,
      solution.minimumTeachings(
        2,
        arrayOf(intArrayOf(1), intArrayOf(2), intArrayOf(1, 2)),
        arrayOf(
          intArrayOf(1, 2),
          intArrayOf(1, 3),
          intArrayOf(2, 3)
        )
      )
    )
  }
}

