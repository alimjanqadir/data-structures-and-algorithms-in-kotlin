package problems

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FindThePrefixCommonArrayOfTwoArraysTest {
  @Test
  fun testExample1() {
    val a = intArrayOf(1,3,2,4)
    val b = intArrayOf(3,1,2,4)

    assertArrayEquals(intArrayOf(0,2,3,4), findThePrefixCommonArray(a, b))
  }

  @Test
  fun testExample2() {
    val a = intArrayOf(2,3,1)
    val b = intArrayOf(3,1,2)

    assertArrayEquals(intArrayOf(0,1,3), findThePrefixCommonArray(a, b))
  }
}
