package problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestUnequalAdjacentGroupsSubsequenceITest {
    @Test
    fun testExample1() {
        val words = arrayOf("a", "b", "c", "d")
        val groups = intArrayOf(1, 2, 1, 2)
        val expected = listOf("a", "b", "c", "d")
        assertEquals(expected, longestUnequalAdjacentGroupsSubsequenceI(words, groups))
    }

    @Test
    fun testSingleGroup() {
        val words = arrayOf("a", "b", "c")
        val groups = intArrayOf(1, 1, 1)
        val expected = listOf("a")
        assertEquals(expected, longestUnequalAdjacentGroupsSubsequenceI(words, groups))
    }

    @Test
    fun testEmpty() {
        val words = arrayOf<String>()
        val groups = intArrayOf()
        val expected = listOf<String>()
        assertEquals(expected, longestUnequalAdjacentGroupsSubsequenceI(words, groups))
    }

    @Test
    fun testAlternating() {
        val words = arrayOf("a", "b", "c", "d", "e")
        val groups = intArrayOf(1, 2, 1, 2, 1)
        val expected = listOf("a", "b", "c", "d", "e")
        assertEquals(expected, longestUnequalAdjacentGroupsSubsequenceI(words, groups))
    }

    @Test
    fun testLongerGroups() {
        val words = arrayOf("a", "a", "b", "b", "c", "c")
        val groups = intArrayOf(1, 1, 2, 2, 1, 1)
        val expected = listOf("a", "b", "c")
        assertEquals(expected, longestUnequalAdjacentGroupsSubsequenceI(words, groups))
    }
}
