package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MaximumCandiesYouCanGetFromBoxesTest {
    
  @Test
  fun testMaxCandies() {
    // Test case 1
    val status1 = intArrayOf(1, 0, 1, 0)
    val candies1 = intArrayOf(7, 5, 4, 100)
    val keysInBox1 = arrayOf(intArrayOf(), intArrayOf(), intArrayOf(1), intArrayOf())
    val containedBoxes1 = arrayOf(intArrayOf(1, 2), intArrayOf(3), intArrayOf(), intArrayOf())
    val initialBoxes1 = intArrayOf(0)
    assertEquals(16, maxCandies(status1, candies1, keysInBox1, containedBoxes1, initialBoxes1))
        
    // Test case 2
    val status2 = intArrayOf(1, 0, 0, 0, 0, 0)
    val candies2 = intArrayOf(1, 1, 1, 1, 1, 1)
    val keysInBox2 = arrayOf(
      intArrayOf(1, 2, 3, 4, 5), 
      intArrayOf(), 
      intArrayOf(), 
      intArrayOf(), 
      intArrayOf(), 
      intArrayOf()
    )
    val containedBoxes2 = arrayOf(
      intArrayOf(1, 2, 3, 4, 5), 
      intArrayOf(), 
      intArrayOf(), 
      intArrayOf(), 
      intArrayOf(), 
      intArrayOf()
    )
    val initialBoxes2 = intArrayOf(0)
    assertEquals(6, maxCandies(status2, candies2, keysInBox2, containedBoxes2, initialBoxes2))
  }
}
