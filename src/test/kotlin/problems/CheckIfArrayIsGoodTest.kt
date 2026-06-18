package problems

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CheckIfArrayIsGoodTest {

  @Test
  fun testIsGoodPromptExample() {
    assertTrue(isGood(intArrayOf(1, 3, 3, 2)))
  }

  @Test
  fun testIsGoodWhenSizeIsTooSmall() {
    assertFalse(isGood(intArrayOf(2, 1, 3)))
  }

  @Test
  fun testIsGoodMinimumArray() {
    assertTrue(isGood(intArrayOf(1, 1)))
  }

  @Test
  fun testIsGoodWhenLengthDoesNotMatchMaximumValue() {
    assertFalse(isGood(intArrayOf(1, 2, 3, 4)))
  }

  @Test
  fun testIsGoodWhenMissingRequiredValue() {
    assertFalse(isGood(intArrayOf(1, 1, 3, 3)))
  }

  @Test
  fun testIsGoodWhenMaximumValueDoesNotAppearTwice() {
    assertFalse(isGood(intArrayOf(1, 2, 3, 4, 4, 4)))
  }
}
