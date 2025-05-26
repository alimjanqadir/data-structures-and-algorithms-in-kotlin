package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LargestColorValueInADirectedGraphTest {
    @Test
    fun testLargestPathValue() {
        val solution = ::largestPathValue
        
        // Test case 1
        val colors1 = "abaca"
        val edges1 = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4)
        )
        assertEquals(3, solution(colors1, edges1))
        
        // Test case 2 - with cycle
        val colors2 = "a"
        val edges2 = arrayOf(intArrayOf(0, 0))
        assertEquals(-1, solution(colors2, edges2))
        
        // Test case 3 - single node
        val colors3 = "a"
        val edges3 = emptyArray<IntArray>()
        assertEquals(1, solution(colors3, edges3))
    }
}
