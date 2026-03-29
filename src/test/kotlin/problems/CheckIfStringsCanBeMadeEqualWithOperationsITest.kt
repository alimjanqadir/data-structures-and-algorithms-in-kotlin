package problems

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CheckIfStringsCanBeMadeEqualWithOperationsITest {

    @Test
    fun testCanBeEqual() {
        // Test case 1: Basic case - strings can be made equal
        assertTrue(canBeEqual("abcd", "cdab"))

        // Test case 2: Strings already equal
        assertTrue(canBeEqual("abcd", "abcd"))

        // Test case 3: Cannot be made equal - different characters
        assertFalse(canBeEqual("abcd", "dcba"))

        // Test case 4: Same groups but different arrangement (swapped positions 0,2)
        assertTrue(canBeEqual("abdc", "dbac"))

        // Test case 5: Different characters in group A
        assertFalse(canBeEqual("aaab", "baaa"))

        // Test case 6: Different characters in group B
        assertFalse(canBeEqual("abbb", "bbba"))

        // Test case 7: Both groups match
        assertTrue(canBeEqual("aabb", "bbaa"))
    }
}
