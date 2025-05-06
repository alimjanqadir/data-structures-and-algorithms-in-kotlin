import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class BuildArrayFromPermutationTest {
    @Test
    fun testBuildArray() {
        val testCases = listOf(
            Pair(intArrayOf(0, 2, 1, 5, 3, 4), intArrayOf(0, 1, 2, 4, 5, 3)),
            Pair(intArrayOf(5, 0, 1, 2, 3, 4), intArrayOf(4, 5, 0, 1, 2, 3))
        )

        for ((input, expected) in testCases) {
            val result = buildArray(input)
            assertContentEquals(expected, result)
        }
    }
}
