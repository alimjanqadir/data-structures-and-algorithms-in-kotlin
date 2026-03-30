package problems

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CheckIfStringsCanBeMadeEqualWithOperationsIITest {

    @Test
    fun testCheckStrings() {
        // Test case 1: Basic case - strings can be made equal
        assertTrue(checkStrings("abcdba", "cabdab"))

        // Test case 2: Strings already equal
        assertTrue(checkStrings("abcd", "abcd"))

        // Test case 3: Cannot be made equal - different characters
        assertFalse(checkStrings("abcd", "efgh"))

        // Test case 4: Same even indices, different odd indices
        assertFalse(checkStrings("abc", "abd"))

        // Test case 5: Different frequency at even position
        assertFalse(checkStrings("aabc", "abbc"))

        // Test case 6: Different frequency at odd position
        assertFalse(checkStrings("abac", "abbc"))

        // Test case 7: Both even and odd groups match
        assertTrue(checkStrings("aabbcc", "ccbbaa"))

        // Test case 8: Single character strings
        assertTrue(checkStrings("a", "a"))
        assertFalse(checkStrings("a", "b"))

        // Test case 9: Two character strings
        assertTrue(checkStrings("ab", "ab"))
        assertFalse(checkStrings("ab", "ba"))

        // Test case 10: Longer strings with matching groups (swapped within even/odd groups)
        assertTrue(checkStrings("acegbdfh", "ecagbdfh"))
    }
}
