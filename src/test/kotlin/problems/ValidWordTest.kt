import problems.isValidWord
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ValidWordTest {
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
      assertEquals(expected, isValidWord(input))
    }
  }
}
