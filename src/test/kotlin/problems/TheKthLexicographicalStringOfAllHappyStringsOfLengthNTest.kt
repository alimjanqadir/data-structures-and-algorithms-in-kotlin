package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TheKthLexicographicalStringOfAllHappyStringsOfLengthNTest {

    @Test
    fun `test example 1`() {
        val result = getHappyString(1, 3)
        assertEquals("c", result)
    }

    @Test
    fun `test example 2`() {
        val result = getHappyString(1, 4)
        assertEquals("", result)
    }

    @Test
    fun `test example 3`() {
        val result = getHappyString(3, 9)
        assertEquals("cab", result)
    }

    @Test
    fun `test length 1, k 1`() {
        val result = getHappyString(1, 1)
        assertEquals("a", result)
    }

    @Test
    fun `test length 1, k 2`() {
        val result = getHappyString(1, 2)
        assertEquals("b", result)
    }

    @Test
    fun `test length 2, k 1`() {
        val result = getHappyString(2, 1)
        assertEquals("ab", result)
    }

    @Test
    fun `test length 2, k 2`() {
        val result = getHappyString(2, 2)
        assertEquals("ac", result)
    }

    @Test
    fun `test length 2, k 3`() {
        val result = getHappyString(2, 3)
        assertEquals("ba", result)
    }

    @Test
    fun `test length 2, k 6`() {
        val result = getHappyString(2, 6)
        assertEquals("cb", result)
    }

    @Test
    fun `test length 2, k 7 - exceeds total`() {
        val result = getHappyString(2, 7)
        assertEquals("", result)
    }

    @Test
    fun `test length 3, k 1`() {
        val result = getHappyString(3, 1)
        assertEquals("aba", result)
    }

    @Test
    fun `test length 3, k 12`() {
        val result = getHappyString(3, 12)
        assertEquals("cbc", result)
    }

    @Test
    fun `test length 3, k 13 - exceeds total`() {
        val result = getHappyString(3, 13)
        assertEquals("", result)
    }

    @Test
    fun `test length 10, k 1`() {
        val result = getHappyString(10, 1)
        assertEquals("ababababab", result)
    }

    @Test
    fun `test length 10, k 100`() {
        val result = getHappyString(10, 100)
        // Should return a valid string (not empty since total strings = 3 * 2^9 = 1536)
        assert(result.isNotEmpty())
        assertEquals(10, result.length)
        // Verify it's a happy string
        for (i in 0 until result.length - 1) {
            assert(result[i] != result[i + 1]) { "String is not happy: $result" }
        }
        // Verify all characters are from {'a', 'b', 'c'}
        for (char in result) {
            assert(char in 'a'..'c') { "Invalid character in result: $char" }
        }
    }
}
