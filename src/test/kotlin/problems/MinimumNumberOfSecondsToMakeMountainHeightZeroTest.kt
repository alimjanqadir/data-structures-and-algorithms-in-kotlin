import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfSecondsToMakeMountainHeightZeroTest {

    @Test
    fun `test example 1`() {
        val mountainHeight = 4
        val workerTimes = intArrayOf(2, 1, 1)
        val expected = 3L
        val result = minNumberOfSeconds(mountainHeight, workerTimes)
        assertEquals(expected, result)
    }

    @Test
    fun `test example 2`() {
        val mountainHeight = 10
        val workerTimes = intArrayOf(3, 2, 2, 4)
        val expected = 12L
        val result = minNumberOfSeconds(mountainHeight, workerTimes)
        assertEquals(expected, result)
    }

    @Test
    fun `test example 3`() {
        val mountainHeight = 5
        val workerTimes = intArrayOf(1)
        val expected = 15L
        val result = minNumberOfSeconds(mountainHeight, workerTimes)
        assertEquals(expected, result)
    }
}
