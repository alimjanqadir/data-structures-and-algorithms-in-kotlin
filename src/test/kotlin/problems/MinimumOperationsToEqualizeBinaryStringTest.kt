import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MinimumOperationsToEqualizeBinaryStringTest {

    @Test
    fun `test case 1`() {
        val result = minOperations("110100110", 3)
        assertEquals(2, result)
    }

    @Test
    fun `test case 2`() {
        val result = minOperations("110100110", 2)
        assertEquals(2, result)
    }

    @Test
    fun `test case 3`() {
        val result = minOperations("11111", 3)
        assertEquals(0, result)
    }

    @Test
    fun `test case 4`() {
        val result = minOperations("00000", 3)
        assertEquals(3, result)
    }

    @Test
    fun `test case 5`() {
        val result = minOperations("101010", 2)
        assertEquals(-1, result)
    }

    @Test
    fun `test case 6`() {
        val result = minOperations("101010", 3)
        assertEquals(1, result)
    }

    @Test
    fun `test case 7`() {
        val result = minOperations("1", 1)
        assertEquals(0, result)
    }

    @Test
    fun `test case 8`() {
        val result = minOperations("0", 1)
        assertEquals(1, result)
    }

    @Test
    fun `test case 9`() {
        val result = minOperations("10", 1)
        assertEquals(1, result)
    }

    @Test
    fun `test case 10`() {
        val result = minOperations("1100", 2)
        assertEquals(1, result)
    }

    @Test
    fun `test case 11`() {
        val result = minOperations("1100", 3)
        assertEquals(2, result)
    }

    @Test
    fun `test case 12`() {
        val result = minOperations("1100", 4)
        assertEquals(-1, result)
    }

    @Test
    fun `test case 13`() {
        val result = minOperations("101", 2)
        assertEquals(-1, result)
    }

    @Test
    fun `test case 14`() {
        val result = minOperations("101", 1)
        assertEquals(1, result)
    }

    @Test
    fun `test case 15`() {
        val result = minOperations("111000", 3)
        assertEquals(1, result)
    }

    @Test
    fun `test case 16`() {
        val result = minOperations("111000", 2)
        assertEquals(-1, result)
    }

    @Test
    fun `test case 17`() {
        val result = minOperations("111000", 1)
        assertEquals(3, result)
    }

    @Test
    fun `test case 18`() {
        val result = minOperations("111000", 6)
        assertEquals(-1, result)
    }

    @Test
    fun `test case 19`() {
        val result = minOperations("1010101010", 2)
        assertEquals(-1, result)
    }

    @Test
    fun `test case 20`() {
        val result = minOperations("1010101010", 5)
        assertEquals(1, result)
    }
}
