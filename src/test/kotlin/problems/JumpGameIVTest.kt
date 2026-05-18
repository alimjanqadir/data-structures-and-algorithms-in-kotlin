package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class JumpGameIVTest {
  @Test
  fun minJumpsReturnsMinimumJumpsForSampleWithRepeatedValues() {
    assertEquals(3, minJumps(intArrayOf(100, -23, -23, 404, 100, 23, 23, 23, 3, 404)))
  }

  @Test
  fun minJumpsReturnsZeroForSingleElementArray() {
    assertEquals(0, minJumps(intArrayOf(7)))
  }

  @Test
  fun minJumpsCanJumpDirectlyAcrossMatchingValues() {
    assertEquals(1, minJumps(intArrayOf(7, 6, 9, 6, 9, 6, 9, 7)))
  }

  @Test
  fun minJumpsWalksThroughArrayWhenNoShortcutExists() {
    assertEquals(2, minJumps(intArrayOf(6, 1, 9)))
  }
}
