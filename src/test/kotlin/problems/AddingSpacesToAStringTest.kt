package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class AddingSpacesToAStringTest {
    
    @Test
    fun `test adding spaces to string`() {
        // Test case 1: Basic case with spaces at indices 4 and 8
        assertEquals(
            "Leet Code iscool",
            addSpaces("LeetCodeiscool", intArrayOf(4, 8))
        )

        // Test case 2: Multiple spaces at indices 1 and 6
        assertEquals(
            "i lovel eetcode",
            addSpaces("iloveleetcode", intArrayOf(1, 6))
        )

        // Test case 3: Space at the beginning (index 0) and at index 5
        assertEquals(
            " hello world",
            addSpaces("helloworld", intArrayOf(0, 5))
        )

        // Test case 4: Empty spaces array
        assertEquals(
            "abc",
            addSpaces("abc", intArrayOf())
        )

        // Test case 5: Multiple consecutive spaces
        assertEquals(
            " a b c d",
            addSpaces("abcd", intArrayOf(0, 1, 2, 3))
        )
    }
}
