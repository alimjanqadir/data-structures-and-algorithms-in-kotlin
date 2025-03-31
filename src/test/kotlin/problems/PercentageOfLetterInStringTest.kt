package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class PercentageOfLetterInStringTest {
    
    @Test
    fun `test percentage of letter in string`() {
        // Test case 1: Basic case with letter 'o' in "foobar"
        assertEquals(
            33,
            percentageLetter("foobar", 'o')
        )

        // Test case 2: Letter not present in string
        assertEquals(
            0,
            percentageLetter("jjjj", 'k')
        )

        // Test case 3: Letter present multiple times
        assertEquals(
            37,
            percentageLetter("leetcode", 'e')
        )

        // Test case 4: Letter present in all positions
        assertEquals(
            100,
            percentageLetter("aaaaa", 'a')
        )

        // Test case 5: Empty string
        assertEquals(
            0,
            percentageLetter("", 'a')
        )
        
        // Test case 6: Single character string with matching letter
        assertEquals(
            100,
            percentageLetter("z", 'z')
        )
        
        // Test case 7: Single character string with non-matching letter
        assertEquals(
            0,
            percentageLetter("z", 'a')
        )
    }
}
