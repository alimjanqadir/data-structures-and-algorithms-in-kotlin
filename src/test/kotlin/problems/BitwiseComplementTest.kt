package problems

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class BitwiseComplementTest {

    @Test
    fun `test bitwise complement with example cases`() {
        assertEquals(2, bitwiseComplement(5)) // 101 -> 010 = 2
        assertEquals(0, bitwiseComplement(7)) // 111 -> 000 = 0
        assertEquals(5, bitwiseComplement(10)) // 1010 -> 0101 = 5
    }

    @Test
    fun `test bitwise complement with zero`() {
        assertEquals(1, bitwiseComplement(0)) // Special case: 0 -> 1
    }

    @Test
    fun `test bitwise complement with power of two`() {
        assertEquals(0, bitwiseComplement(1)) // 1 -> 0 = 0
        assertEquals(1, bitwiseComplement(2)) // 10 -> 01 = 1
        assertEquals(3, bitwiseComplement(4)) // 100 -> 011 = 3
        assertEquals(7, bitwiseComplement(8)) // 1000 -> 0111 = 7
    }

    @Test
    fun `test bitwise complement with consecutive ones`() {
        assertEquals(0, bitwiseComplement(1)) // 1 -> 0 = 0
        assertEquals(0, bitwiseComplement(3)) // 11 -> 00 = 0
        assertEquals(0, bitwiseComplement(7)) // 111 -> 000 = 0
    }

    @Test
    fun `test bitwise complement with mixed patterns`() {
        assertEquals(2, bitwiseComplement(5)) // 101 -> 010 = 2
        assertEquals(5, bitwiseComplement(10)) // 1010 -> 0101 = 5
        assertEquals(0, bitwiseComplement(3)) // 11 -> 00 = 0
    }

    @Test
    fun `test bitwise complement with larger numbers`() {
        assertEquals(15, bitwiseComplement(16)) // 10000 -> 01111 = 15
        assertEquals(31, bitwiseComplement(32)) // 100000 -> 011111 = 31
        assertEquals(1, bitwiseComplement(2)) // 10 -> 01 = 1
    }

    @Test
    fun `test bitwise complement edge cases`() {
        assertEquals(1, bitwiseComplement(0)) // Special case
        assertEquals(0, bitwiseComplement(1)) // 1 -> 0 = 0
    }
}
