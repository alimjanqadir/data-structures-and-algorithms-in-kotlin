package problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountLargestGroupTest {
    @Test
    fun testExample1() {
        assertEquals(4, countLargestGroup(13))
    }

    @Test
    fun testExample2() {
        assertEquals(2, countLargestGroup(2))
    }

    @Test
    fun testExample3() {
        assertEquals(5, countLargestGroup(24))
    }

    @Test
    fun testSingle() {
        assertEquals(1, countLargestGroup(1))
    }

    @Test
    fun testLarger() {
        assertEquals(1, countLargestGroup(10000))
    }
}
