import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ChampagneTowerTest {

  @Test
  fun testExample1() {
    val poured = 1
    val queryRow = 1
    val queryGlass = 1
    val expected = 0.0
    val actual = champagneTower(poured, queryRow, queryGlass)
    assertEquals(expected, actual, 1e-9)
  }

  @Test
  fun testExample2() {
    val poured = 2
    val queryRow = 1
    val queryGlass = 1
    val expected = 0.5
    val actual = champagneTower(poured, queryRow, queryGlass)
    assertEquals(expected, actual, 1e-9)
  }

  @Test
  fun testExample3() {
    val poured = 100000009
    val queryRow = 33
    val queryGlass = 17
    val expected = 1.0
    val actual = champagneTower(poured, queryRow, queryGlass)
    assertEquals(expected, actual, 1e-9)
  }

  @Test
  fun testTopGlass() {
    val poured = 5
    val queryRow = 0
    val queryGlass = 0
    val expected = 1.0
    val actual = champagneTower(poured, queryRow, queryGlass)
    assertEquals(expected, actual, 1e-9)
  }

  @Test
  fun testEdgeGlasses() {
    val poured = 4
    val queryRow = 2
    val queryGlass = 0
    val expected = 0.25
    val actual = champagneTower(poured, queryRow, queryGlass)
    assertEquals(expected, actual, 1e-9)

    val expected2 = 0.25
    val actual2 = champagneTower(poured, queryRow, 2)
    assertEquals(expected2, actual2, 1e-9)
  }

  @Test
  fun testMiddleGlass() {
    val poured = 4
    val queryRow = 2
    val queryGlass = 1
    val expected = 0.5
    val actual = champagneTower(poured, queryRow, queryGlass)
    assertEquals(expected, actual, 1e-9)
  }

  @Test
  fun testZeroPoured() {
    val poured = 0
    val queryRow = 3
    val queryGlass = 1
    val expected = 0.0
    val actual = champagneTower(poured, queryRow, queryGlass)
    assertEquals(expected, actual, 1e-9)
  }

  @Test
  fun testLargeRowSmallPoured() {
    val poured = 1
    val queryRow = 10
    val queryGlass = 5
    val expected = 0.0
    val actual = champagneTower(poured, queryRow, queryGlass)
    assertEquals(expected, actual, 1e-9)
  }
}
