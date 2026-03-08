package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class FindDifferentBinaryStringTest {

  @Test
  fun `test length 1`() {
    val input = arrayOf("0")
    val result = findDifferentBinaryString(input)
    assertEquals(1, result.length)
    assertTrue(result !in input)
  }

  @Test
  fun `test length 2`() {
    val input = arrayOf("00", "01")
    val result = findDifferentBinaryString(input)
    assertEquals(2, result.length)
    assertTrue(result !in input)
  }

  @Test
  fun `test length 3`() {
    val input = arrayOf("000", "001", "010")
    val result = findDifferentBinaryString(input)
    assertEquals(3, result.length)
    assertTrue(result !in input)
  }

  @Test
  fun `test length 4`() {
    val input = arrayOf("0000", "0001", "0010", "0011")
    val result = findDifferentBinaryString(input)
    assertEquals(4, result.length)
    assertTrue(result !in input)
  }

  @Test
  fun `test diagonal method verification`() {
    val input = arrayOf("01", "11")
    val result = findDifferentBinaryString(input)
    assertEquals(2, result.length)
    assertTrue(result !in input)
  }

  @Test
  fun `test missing all zeros`() {
    val input = arrayOf("01", "10")
    val result = findDifferentBinaryString(input)
    assertEquals(2, result.length)
    assertTrue(result !in input)
  }

  @Test
  fun `test missing all ones`() {
    val input = arrayOf("00", "01")
    val result = findDifferentBinaryString(input)
    assertEquals(2, result.length)
    assertTrue(result !in input)
  }

  @Test
  fun `test random missing string`() {
    val input = arrayOf("000", "001", "010")
    val result = findDifferentBinaryString(input)
    assertEquals(3, result.length)
    assertTrue(result !in input)
  }
}
