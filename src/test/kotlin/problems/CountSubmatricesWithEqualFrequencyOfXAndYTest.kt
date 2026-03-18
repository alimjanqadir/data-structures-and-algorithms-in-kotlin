package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CountSubmatricesWithEqualFrequencyOfXAndYTest {
    @Test
    fun example1() {
        val grid = arrayOf(
            charArrayOf('X', 'Y', '.'),
            charArrayOf('Y', '.', '.')
        )
        assertEquals(3, numberOfSubmatrices(grid))
    }

    @Test
    fun example2() {
        val grid = arrayOf(
            charArrayOf('X', 'X'),
            charArrayOf('X', 'Y')
        )
        assertEquals(0, numberOfSubmatrices(grid))
    }

    @Test
    fun singleX() {
        val grid = arrayOf(
            charArrayOf('X')
        )
        assertEquals(0, numberOfSubmatrices(grid))
    }

    @Test
    fun singleY() {
        val grid = arrayOf(
            charArrayOf('Y')
        )
        assertEquals(0, numberOfSubmatrices(grid))
    }

    @Test
    fun singleDot() {
        val grid = arrayOf(
            charArrayOf('.')
        )
        assertEquals(0, numberOfSubmatrices(grid))
    }

    @Test
    fun allXNoY() {
        val grid = arrayOf(
            charArrayOf('X', 'X'),
            charArrayOf('X', 'X')
        )
        assertEquals(0, numberOfSubmatrices(grid))
    }

    @Test
    fun balancedXY() {
        val grid = arrayOf(
            charArrayOf('X', 'Y'),
            charArrayOf('Y', 'X')
        )
        assertEquals(3, numberOfSubmatrices(grid))
    }
}
