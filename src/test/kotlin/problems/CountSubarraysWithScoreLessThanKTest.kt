package problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountSubarraysWithScoreLessThanKTest {
    @Test
    fun example1() {
        val nums = intArrayOf(2, 1, 4, 3)
        val k = 10L
        val result = countSubarraysWithScoreLessThanK(nums, k)
        println("Test example1: result = $result")
        assertEquals(5L, result)
    }

    @Test
    fun example2() {
        val nums = intArrayOf(1, 1, 1)
        val k = 5L
        assertEquals(5L, countSubarraysWithScoreLessThanK(nums, k))
    }

    @Test
    fun singleElement() {
        val nums = intArrayOf(10)
        val k = 11L
        assertEquals(1L, countSubarraysWithScoreLessThanK(nums, k))
    }

    @Test
    fun allInvalid() {
        val nums = intArrayOf(10, 10, 10)
        val k = 10L
        assertEquals(0L, countSubarraysWithScoreLessThanK(nums, k))
    }

    @Test
    fun largeK() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        val k = 100L
        assertEquals(15L, countSubarraysWithScoreLessThanK(nums, k))
    }
}
