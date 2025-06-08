import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RabbitsInForestTest {
  @Test
  fun testExample1() {
    val answers = intArrayOf(1, 1, 2)
    assertEquals(5, numRabbits(answers))
  }

  @Test
  fun testExample2() {
    val answers = intArrayOf(10, 10, 10)
    assertEquals(11, numRabbits(answers))
  }

  @Test
  fun testExample3() {
    val answers = intArrayOf()
    assertEquals(0, numRabbits(answers))
  }

  @Test
  fun testAllSame() {
    val answers = intArrayOf(0, 0, 0)
    assertEquals(3, numRabbits(answers))
  }

  @Test
  fun testAllDifferent() {
    val answers = intArrayOf(0, 1, 2, 3)
    assertEquals(10, numRabbits(answers))
  }
}
