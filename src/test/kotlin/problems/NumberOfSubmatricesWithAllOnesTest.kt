package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class NumberOfSubmatricesWithAllOnesTest {
  @Test
  fun testNumSubmat() {
    val mat1 = arrayOf(
      intArrayOf(1, 0, 1),
      intArrayOf(1, 1, 0),
      intArrayOf(1, 1, 0)
    )
    assertEquals(13, numSubmat(mat1))

    val mat2 = arrayOf(
      intArrayOf(0, 1, 1, 0),
      intArrayOf(0, 1, 1, 1),
      intArrayOf(1, 1, 1, 0)
    )
    assertEquals(24, numSubmat(mat2))
  }
}

