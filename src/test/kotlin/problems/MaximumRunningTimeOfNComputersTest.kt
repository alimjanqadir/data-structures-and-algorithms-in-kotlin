package problems

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaximumRunningTimeOfNComputersTest {
    @Test
    fun testMaxRunTime() {
        // Test case 1
        assertEquals(4, maxRunTime(2, intArrayOf(3, 3, 3)))
        
        // Test case 2
        assertEquals(2, maxRunTime(2, intArrayOf(1, 1, 1, 1)))
        
        // Test case 3
        assertEquals(4, maxRunTime(3, intArrayOf(3, 3, 3, 3, 3, 3)))
    }
}
