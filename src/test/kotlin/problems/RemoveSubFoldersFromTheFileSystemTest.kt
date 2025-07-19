package problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveSubFoldersFromTheFileSystemTest {
  @Test
  fun example1() {
    val folder = arrayOf("/a","/a/b","/c/d","/c/d/e","/c/f")
    val expected = listOf("/a","/c/d","/c/f")
    assertEquals(expected, removeSubfolders(folder))
  }

  @Test
  fun example2() {
    val folder = arrayOf("/a","/a/b/c","/a/b/d")
    val expected = listOf("/a")
    assertEquals(expected, removeSubfolders(folder))
  }

  @Test
  fun noSubfolders() {
    val folder = arrayOf("/a","/b","/c")
    val expected = listOf("/a","/b","/c")
    assertEquals(expected, removeSubfolders(folder))
  }
}
