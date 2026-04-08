package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class XorAfterRangeMultiplicationQueriesTest {

    @Test
    fun testExample1() {
        val nums = intArrayOf(1, 1, 1)
        val queries = arrayOf(intArrayOf(0, 2, 1, 4))
        assertEquals(4, xorAfterQueries(nums, queries))
    }

    @Test
    fun testExample2() {
        val nums = intArrayOf(2, 3, 1, 5, 4)
        val queries = arrayOf(intArrayOf(1, 4, 2, 3), intArrayOf(0, 2, 1, 2))
        assertEquals(31, xorAfterQueries(nums, queries))
    }
}
