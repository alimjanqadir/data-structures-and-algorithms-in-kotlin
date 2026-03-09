package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class FindAllPossibleStableBinaryArraysITest {

  @Test
  fun `test basic case 1`() {
    // zero = 1, one = 1, limit = 1
    // Possible arrays: [0,1], [1,0]
    assertEquals(2, numberOfStableArrays(1, 1, 1))
  }

  @Test
  fun `test basic case 2`() {
    // zero = 1, one = 2, limit = 1
    // Only [1,0,1] is valid since any subarray >1 must contain both 0 and 1
    assertEquals(1, numberOfStableArrays(1, 2, 1))
  }

  @Test
  fun `test limit constraint`() {
    // zero = 2, one = 1, limit = 1
    // Only [0,1,0] is valid since any subarray >1 must contain both 0 and 1
    assertEquals(1, numberOfStableArrays(2, 1, 1))
  }

  @Test
  fun `test larger limit`() {
    // zero = 2, one = 2, limit = 2
    // More combinations allowed since limit is larger
    val result = numberOfStableArrays(2, 2, 2)
    assertEquals(6, result)
  }

  @Test
  fun `test single zero`() {
    // zero = 1, one = 0, limit = 1
    // Only array: [0]
    assertEquals(1, numberOfStableArrays(1, 0, 1))
  }

  @Test
  fun `test single one`() {
    // zero = 0, one = 1, limit = 1
    // Only array: [1]
    assertEquals(1, numberOfStableArrays(0, 1, 1))
  }

  @Test
  fun `test equal counts with limit 1`() {
    // zero = 3, one = 3, limit = 1
    // Must alternate completely: [0,1,0,1,0,1] and [1,0,1,0,1,0]
    assertEquals(2, numberOfStableArrays(3, 3, 1))
  }

  @Test
  fun `test larger numbers`() {
    // Test with larger numbers to verify modulo operation
    val result = numberOfStableArrays(5, 5, 2)
    assertTrue(result > 0)
    assertTrue(result < 1_000_000_007)
  }

  @Test
  fun `test limit greater than counts`() {
    // zero = 2, one = 2, limit = 10
    // Limit is effectively not constraining
    val result = numberOfStableArrays(2, 2, 10)
    assertEquals(6, result)
  }
}
