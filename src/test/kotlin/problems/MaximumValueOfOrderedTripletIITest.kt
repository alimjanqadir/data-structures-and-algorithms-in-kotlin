import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MaximumValueOfOrderedTripletIITest {
  @Test
  fun testMaximumTripletValue() {
    assertEquals(77, maximumTripletValue(intArrayOf(12, 6, 1, 2, 7)))
    assertEquals(133, maximumTripletValue(intArrayOf(1, 10, 3, 4, 19)))
    assertEquals(0, maximumTripletValue(intArrayOf(1, 2, 3)))
    assertEquals(72, maximumTripletValue(intArrayOf(10, 1, 5, 8, 2)))
    assertEquals(0, maximumTripletValue(intArrayOf(2, 3, 1)))
  }
}
