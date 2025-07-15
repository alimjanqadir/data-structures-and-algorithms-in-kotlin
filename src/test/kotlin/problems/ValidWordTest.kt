import leetcode.Solution
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ValidWordTest {
  private val solution = Solution()

  @Test
  fun testIsValidWord() {
    val testCases = listOf(
      "234Adas" to true,
      "b3" to false,
      "AcA" to true,
      "jav!a" to false,
      "cake" to true
    )

    for ((input, expected) in testCases) {
      assertEquals(expected, solution.isValid(input))
    }
  }
}
