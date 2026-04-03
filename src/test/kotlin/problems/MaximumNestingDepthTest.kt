package problems

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertTrue

class MaximumNestingDepthTest {

  @Test
  fun testMaxDepthAfterSplitExample() {
    val s = "(())(())"
    val expected = intArrayOf(2, 2)
    assertContentEquals(expected, maxDepthAfterSplit(s))
  }

  @Test
  fun testMaxDepthAfterSplitSingleGroup() {
    val s = "()"
    val expected = intArrayOf(1)
    assertContentEquals(expected, maxDepthAfterSplit(s))
  }

  @Test
  fun testMaxDepthAfterSplitNested() {
    val s = "((()))"
    val expected = intArrayOf(3)
    assertContentEquals(expected, maxDepthAfterSplit(s))
  }

  @Test
  fun testMaxDepthAfterSplitMultipleGroups() {
    val s = "()()()"
    val expected = intArrayOf(1, 1, 1)
    assertContentEquals(expected, maxDepthAfterSplit(s))
  }

  @Test
  fun testMaxDepthAfterSplitComplex() {
    val s = "(())()(())((()))"
    val expected = intArrayOf(2, 1, 2, 3)
    assertContentEquals(expected, maxDepthAfterSplit(s))
  }

  @Test
  fun testMaxDepthAfterSplitDeepNesting() {
    val s = "((((((()))))))"
    val expected = intArrayOf(6)
    assertContentEquals(expected, maxDepthAfterSplit(s))
  }

  @Test
  fun testMaxDepthAfterSplitEmptyGroups() {
    val s = "()()()()"
    val expected = intArrayOf(1, 1, 1, 1)
    assertContentEquals(expected, maxDepthAfterSplit(s))
  }

  @Test
  fun testMaxDepthAfterSplitDifferentDepths() {
    val s = "(())((()))(((())))"
    val expected = intArrayOf(2, 3, 4)
    assertContentEquals(expected, maxDepthAfterSplit(s))
  }

  @Test
  fun testMaxDepthAfterSplitSingleChar() {
    // Edge case: a single character that is not parentheses
    val s = ""
    val result = maxDepthAfterSplit(s)
    assertTrue(result.isEmpty())
  }
}
