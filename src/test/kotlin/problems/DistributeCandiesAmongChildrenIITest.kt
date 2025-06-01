package problems

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DistributeCandiesAmongChildrenIITest {
    @Test
    fun testDistributeCandies() {
        val solution = ::distributeCandies
        
        // Test case 1
        assertEquals(3, solution(5, 2))
        
        // Test case 2
        assertEquals(10, solution(3, 3))
    }
}
