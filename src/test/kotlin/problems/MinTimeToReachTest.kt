import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MinTimeToReachTest {
    @Test
    fun testMinTimeToReach() {
        val moveTime1 = arrayOf(
            intArrayOf(0, 1, 3, 2),
            intArrayOf(5, 1, 2, 5),
            intArrayOf(4, 3, 8, 6)
        )
        assertEquals(7, minTimeToReach(moveTime1))

        val moveTime2 = arrayOf(
            intArrayOf(0, 2, 4),
            intArrayOf(3, 2, 1),
            intArrayOf(5, 0, 0)
        )
        assertEquals(3, minTimeToReach(moveTime2))
    }
}
