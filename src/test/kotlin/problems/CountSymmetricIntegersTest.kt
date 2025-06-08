package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CountSymmetricIntegersTest {
  @Test
  fun testCountSymmetricIntegers() {
    assertEquals(9, countSymmetricIntegers(1, 100)) // 11, 22, 33, 44, 55, 66, 77, 88, 99
    assertEquals(4, countSymmetricIntegers(1200, 1230)) // 1200, 1211, 1222, 1233
    assertEquals(1, countSymmetricIntegers(10, 11)) // 11
    assertEquals(9, countSymmetricIntegers(1, 99)) // 11, 22, 33, 44, 55, 66, 77, 88, 99
  }
}
