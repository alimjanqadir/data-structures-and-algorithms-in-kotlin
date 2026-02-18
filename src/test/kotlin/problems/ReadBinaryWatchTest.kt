import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ReadBinaryWatchTest {

  @Test
  fun testReadBinaryWatchZero() {
    val expected = listOf("0:00")
    assertEquals(expected, readBinaryWatch(0))
  }

  @Test
  fun testReadBinaryWatchOne() {
    val result = readBinaryWatch(1)
    val expected = listOf("0:01", "0:02", "0:04", "0:08", "0:16", "0:32", "1:00", "2:00", "4:00", "8:00")
    assertEquals(expected.size, result.size)
    assertEquals(expected.sorted(), result.sorted())
  }

  @Test
  fun testReadBinaryWatchBasic() {
    val result = readBinaryWatch(2)
    assertTrue(result.isNotEmpty())
  }

  @Test
  fun testReadBinaryWatchInvalid() {
    val result = readBinaryWatch(11)
    assertTrue(result.isEmpty())
  }
}
