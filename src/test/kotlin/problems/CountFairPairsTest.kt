package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CountFairPairsTest {
    @Test
    fun example1() {
        val nums = intArrayOf(0, 1, 7, 4, 4, 5)
        assertEquals(6L, countFairPairs(nums, 3, 6))
    }

    @Test
    fun allPairsWithin() {
        val nums = intArrayOf(1, 2, 3, 4)
        assertEquals(6L, countFairPairs(nums, 3, 7))
    }

    @Test
    fun noPairsWithin() {
        val nums = intArrayOf(5, 6, 7)
        assertEquals(0L, countFairPairs(nums, 1, 4))
    }

    @Test
    fun singleElement() {
        val nums = intArrayOf(10)
        assertEquals(0L, countFairPairs(nums, 5, 15))
    }

    @Test
    fun negativeAndPositive() {
        val nums = intArrayOf(-2, 0, 1, 3)
        assertEquals(4L, countFairPairs(nums, -2, 1))
    }
}
