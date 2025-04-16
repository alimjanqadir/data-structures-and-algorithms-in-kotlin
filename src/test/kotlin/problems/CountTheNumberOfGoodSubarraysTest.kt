package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CountTheNumberOfGoodSubarraysTest {
    @Test
    fun example1() {
        val nums = intArrayOf(1,1,1,1,1)
        val k = 10
        assertEquals(1, countGood(nums, k))
    }

    @Test
    fun example2() {
        val nums = intArrayOf(3,1,4,3,2,2,4)
        val k = 2
        assertEquals(4, countGood(nums, k))
    }

    @Test
    fun leetcodeSample1() {
        val nums = intArrayOf(1,1,2,1,2,2,2)
        val k = 3
        assertEquals(10, countGood(nums, k))
    }

    @Test
    fun edgeCaseNoPairs() {
        val nums = intArrayOf(1,2,3,4)
        val k = 1
        assertEquals(0, countGood(nums, k))
    }

    @Test
    fun allPairs() {
        val nums = intArrayOf(1,1,1,1)
        val k = 3
        assertEquals(3, countGood(nums, k))
    }
}
