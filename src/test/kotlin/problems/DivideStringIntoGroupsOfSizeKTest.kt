package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class DivideStringIntoGroupsOfSizeKTest {
  @Test
  fun `exact multiple of group size`() {
    val result = divideString("abcdef", 2, 'x')
    assertContentEquals(arrayOf("ab", "cd", "ef"), result)
  }

  @Test
  fun `requires padding`() {
    val result = divideString("abcdefghij", 3, 'x')
    assertContentEquals(arrayOf("abc", "def", "ghi", "jxx"), result)
  }

  @Test
  fun `group size of one`() {
    val result = divideString("abc", 1, 'z')
    assertContentEquals(arrayOf("a", "b", "c"), result)
  }

  @Test
  fun `empty string`() {
    val result = divideString("", 3, 'x')
    assertContentEquals(emptyArray(), result)
  }
}
