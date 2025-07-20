package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DeleteDuplicateFoldersInSystemTest {
  @Test
  fun example1() {
    val paths = listOf(
      listOf("a"),
      listOf("c"),
      listOf("d"),
      listOf("a", "b"),
      listOf("c", "b"),
      listOf("d", "a")
    )
    val expected = listOf(
      listOf("d"),
      listOf("d", "a")
    )
    assertEquals(expected.toSet(), deleteDuplicateFolder(paths).toSet())
  }

  @Test
  fun example2() {
    val paths = listOf(
      listOf("a"),
      listOf("c"),
      listOf("a", "b"),
      listOf("c", "b"),
      listOf("a", "b", "x"),
      listOf("a", "b", "x", "y"),
      listOf("w"),
      listOf("w", "y")
    )
    val expected = listOf(
      listOf("c"),
      listOf("c", "b"),
      listOf("a"),
      listOf("a", "b")
    )
    assertEquals(expected.toSet(), deleteDuplicateFolder(paths).toSet())
  }

  @Test
  fun example3() {
    val paths = listOf(
      listOf("a", "b"),
      listOf("c", "d"),
      listOf("c"),
      listOf("a")
    )
    val expected = listOf(
      listOf("c"),
      listOf("c", "d"),
      listOf("a"),
      listOf("a", "b")
    )
    assertEquals(expected.toSet(), deleteDuplicateFolder(paths).toSet())
  }
}
