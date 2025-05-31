package problems

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SnakesAndLaddersTest {
    @Test
    fun testExample1() {
        val board = arrayOf(
            intArrayOf(-1,-1,-1,-1,-1,-1),
            intArrayOf(-1,-1,-1,-1,-1,-1),
            intArrayOf(-1,-1,-1,-1,-1,-1),
            intArrayOf(-1,35,-1,-1,13,-1),
            intArrayOf(-1,-1,-1,-1,-1,-1),
            intArrayOf(-1,15,-1,-1,-1,-1)
        )
        assertEquals(4, snakesAndLadders(board))
    }


    @Test
    fun testExample2() {
        val board = arrayOf(
            intArrayOf(-1,-1),
            intArrayOf(-1,3)
        )
        assertEquals(1, snakesAndLadders(board))
    }

    @Test
    fun testNoSolution() {
        val board = arrayOf(
            intArrayOf(1, 1, -1),
            intArrayOf(1, 1, 1),
            intArrayOf(-1, 1, 1)
        )
        assertEquals(-1, snakesAndLadders(board))
    }
}
