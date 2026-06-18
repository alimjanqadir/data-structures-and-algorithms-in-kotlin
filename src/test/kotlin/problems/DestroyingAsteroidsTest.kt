package problems

import kotlin.test.assertFalse
import kotlin.test.assertTrue
import org.junit.jupiter.api.Test

class DestroyingAsteroidsTest {
  @Test
  fun example1() {
    val asteroids = intArrayOf(3, 9, 19, 5, 21)

    assertTrue(asteroidsDestroyed(10, asteroids))
  }

  @Test
  fun example2() {
    val asteroids = intArrayOf(4, 9, 23, 4)

    assertFalse(asteroidsDestroyed(5, asteroids))
  }

  @Test
  fun handlesUnsortedAsteroidsByAbsorbingSmallestFirst() {
    val asteroids = intArrayOf(6, 1, 2)

    assertTrue(asteroidsDestroyed(3, asteroids))
  }

  @Test
  fun handlesLargeAccumulatedMass() {
    val asteroids = intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE)

    assertTrue(asteroidsDestroyed(Int.MAX_VALUE, asteroids))
  }
}
