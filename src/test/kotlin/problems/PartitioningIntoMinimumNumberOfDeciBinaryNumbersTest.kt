import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PartitioningIntoMinimumNumberOfDeciBinaryNumbersTest {

  @Test
  fun `test example 1`() {
    assertEquals(3, minPartitions("32"))
  }

  @Test
  fun `test example 2`() {
    assertEquals(8, minPartitions("82734"))
  }

  @Test
  fun `test example 3`() {
    assertEquals(9, minPartitions("27346209830709182346"))
  }

  @Test
  fun `test single digit`() {
    assertEquals(1, minPartitions("1"))
    assertEquals(9, minPartitions("9"))
  }

  @Test
  fun `test all zeros`() {
    assertEquals(0, minPartitions("0"))
    assertEquals(0, minPartitions("000"))
  }

  @Test
  fun `test mixed digits`() {
    assertEquals(5, minPartitions("505"))
    assertEquals(7, minPartitions("7070"))
  }
}
