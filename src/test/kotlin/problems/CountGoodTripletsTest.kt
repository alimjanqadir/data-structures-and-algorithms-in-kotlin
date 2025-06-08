package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CountGoodTripletsTest {
  @Test
  fun testExample1() {
    val nums1 = intArrayOf(2, 0, 1, 3)
    val nums2 = intArrayOf(0, 1, 2, 3)
    assertEquals(1L, countGoodTriplets(nums1, nums2))
  }

  @Test
  fun testExample2() {
    val nums1 = intArrayOf(4, 0, 1, 3, 2)
    val nums2 = intArrayOf(4, 1, 0, 2, 3)
    assertEquals(4L, countGoodTriplets(nums1, nums2))
  }

  @Test
  fun testSmallestCase() {
    val nums1 = intArrayOf(0, 1, 2)
    val nums2 = intArrayOf(0, 1, 2)
    assertEquals(1L, countGoodTriplets(nums1, nums2))
  }

  @Test
  fun testReverseOrder() {
    val nums1 = intArrayOf(2, 1, 0)
    val nums2 = intArrayOf(2, 1, 0)
    val result = countGoodTriplets(nums1, nums2)
    println("ReverseOrder actual result: $result")
    assertEquals(1L, result)
  }

  @Test
  fun testAllIncreasing() {
    val n = 10
    val nums1 = IntArray(n) { it }
    val nums2 = IntArray(n) { it }
    // Number of increasing triplets: C(n, 3)
    assertEquals(120L, countGoodTriplets(nums1, nums2))
  }
}
