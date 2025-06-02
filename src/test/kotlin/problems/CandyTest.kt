package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CandyTest {
    @Test
    fun testCandy() {
        // Test case 1: [1,0,2] -> 5
        assertEquals(5, candy(intArrayOf(1, 0, 2)))
        
        // Test case 2: [1,2,2] -> 4
        assertEquals(4, candy(intArrayOf(1, 2, 2)))
    }
}
