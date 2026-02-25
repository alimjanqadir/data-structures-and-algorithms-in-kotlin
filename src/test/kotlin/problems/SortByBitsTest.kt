package problems

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertArrayEquals

class SortByBitsTest {

  @Test
  fun `test example case 1`() {
    val arr = intArrayOf(0,1,2,3,4,5,6,7,8)
    val expected = intArrayOf(0,1,2,4,8,3,5,6,7)
    assertArrayEquals(expected, sortByBits(arr))
  }

  @Test
  fun `test example case 2`() {
    val arr = intArrayOf(1024,512,256,128,64,32,16,8,4,2,1)
    val expected = intArrayOf(1,2,4,8,16,32,64,128,256,512,1024)
    assertArrayEquals(expected, sortByBits(arr))
  }

  @Test
  fun `test single element`() {
    val arr = intArrayOf(5)
    val expected = intArrayOf(5)
    assertArrayEquals(expected, sortByBits(arr))
  }

  @Test
  fun `test same bit count different values`() {
    // 3(11), 5(101), 6(110) all have 2 bits
    val arr = intArrayOf(3, 5, 6)
    // Should be sorted by value when bit count is same
    val expected = intArrayOf(3, 5, 6)
    assertArrayEquals(expected, sortByBits(arr))
  }

  @Test
  fun `test mixed bit counts`() {
    // 7(111)=3bits, 8(1000)=1bit, 9(1001)=2bits, 10(1010)=2bits
    val arr = intArrayOf(7, 8, 9, 10)
    // 8(1bit), 9&10(2bits sorted by value), 7(3bits)
    val expected = intArrayOf(8, 9, 10, 7)
    assertArrayEquals(expected, sortByBits(arr))
  }

  @Test
  fun `test empty array`() {
    val arr = intArrayOf()
    val expected = intArrayOf()
    assertArrayEquals(expected, sortByBits(arr))
  }

  @Test
  fun `test duplicate values`() {
    val arr = intArrayOf(2, 2, 3, 3)
    // 2(10)=1bit, 3(11)=2bits
    val expected = intArrayOf(2, 2, 3, 3)
    assertArrayEquals(expected, sortByBits(arr))
  }

  @Test
  fun `test large numbers`() {
    // 1023(1111111111)=10bits, 1024(10000000000)=1bit
    val arr = intArrayOf(1023, 1024)
    val expected = intArrayOf(1024, 1023)
    assertArrayEquals(expected, sortByBits(arr))
  }
}
