package problems

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SumOfDistancesTest {
    
    @Test
    fun `test example case 1`() {
        val solution = SumOfDistances()
        val nums = intArrayOf(1, 3, 1, 1, 2)
        val expected = longArrayOf(5, 0, 3, 4, 0)
        val result = solution.distance(nums)
        assertArrayEquals(expected, result)
    }
    
    @Test
    fun `test example case 2`() {
        val solution = SumOfDistances()
        val nums = intArrayOf(0, 5, 3)
        val expected = longArrayOf(0, 0, 0)
        val result = solution.distance(nums)
        assertArrayEquals(expected, result)
    }
    
    @Test
    fun `test single element`() {
        val solution = SumOfDistances()
        val nums = intArrayOf(42)
        val expected = longArrayOf(0)
        val result = solution.distance(nums)
        assertArrayEquals(expected, result)
    }
    
    @Test
    fun `test all same elements`() {
        val solution = SumOfDistances()
        val nums = intArrayOf(5, 5, 5, 5)
        val expected = longArrayOf(3, 2, 2, 3)
        val result = solution.distance(nums)
        assertArrayEquals(expected, result)
    }
    
    @Test
    fun `test all distinct elements`() {
        val solution = SumOfDistances()
        val nums = intArrayOf(1, 2, 3, 4, 5)
        val expected = longArrayOf(0, 0, 0, 0, 0)
        val result = solution.distance(nums)
        assertArrayEquals(expected, result)
    }
    
    @Test
    fun `test alternating pattern`() {
        val solution = SumOfDistances()
        val nums = intArrayOf(1, 2, 1, 2, 1, 2)
        val expected = longArrayOf(6, 6, 4, 4, 6, 6)
        val result = solution.distance(nums)
        assertArrayEquals(expected, result)
    }
    
    @Test
    fun `test large array with repeated values`() {
        val solution = SumOfDistances()
        val nums = intArrayOf(1, 1, 1, 1, 1, 1, 1)
        val expected = longArrayOf(6, 4, 3, 4, 5, 6, 6)
        val result = solution.distance(nums)
        assertArrayEquals(expected, result)
    }
    
    @Test
    fun `test negative values`() {
        val solution = SumOfDistances()
        val nums = intArrayOf(-1, 3, -1, -1, 2)
        val expected = longArrayOf(5, 0, 3, 4, 0)
        val result = solution.distance(nums)
        assertArrayEquals(expected, result)
    }
    
    @Test
    fun `test zero values`() {
        val solution = SumOfDistances()
        val nums = intArrayOf(0, 1, 0, 0, 2)
        val expected = longArrayOf(5, 0, 3, 4, 0)
        val result = solution.distance(nums)
        assertArrayEquals(expected, result)
    }
    
    @Test
    fun `test complex case`() {
        val solution = SumOfDistances()
        val nums = intArrayOf(1, 2, 3, 1, 2, 3, 1, 2, 3)
        val expected = longArrayOf(12, 12, 12, 6, 6, 6, 12, 12, 12)
        val result = solution.distance(nums)
        assertArrayEquals(expected, result)
    }
}
