import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumEquivDominoPairsTest {
    @Test
    fun testExample1() {
        val dominoes = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 1),
            intArrayOf(3, 4),
            intArrayOf(5, 6)
        )
        assertEquals(1, numEquivDominoPairs(dominoes))
    }

    @Test
    fun testExample2() {
        val dominoes = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 2),
            intArrayOf(1, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 2)
        )
        assertEquals(3, numEquivDominoPairs(dominoes))
    }

    @Test
    fun testEmptyArray() {
        val dominoes = arrayOf<IntArray>()
        assertEquals(0, numEquivDominoPairs(dominoes))
    }
}
