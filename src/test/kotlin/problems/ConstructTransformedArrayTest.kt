import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class ConstructTransformedArrayTest {
  @Test
  fun testConstructTransformedArray() {
    val testCases = listOf(
      Pair(intArrayOf(3, -2, 1, 1), intArrayOf(1, 1, 1, 3)),
      Pair(intArrayOf(0, 0, 0), intArrayOf(0, 0, 0)),
      Pair(intArrayOf(-1, 2, -3, 4), intArrayOf(4, 4, 4, 4))
    )

    for ((nums, expected) in testCases) {
      val result = constructTransformedArray(nums)
      assertContentEquals(expected, result)
    }
  }
}
