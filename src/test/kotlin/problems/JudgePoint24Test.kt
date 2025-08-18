package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class JudgePoint24Test {
  @Test
  fun testJudgePoint24() {
    assertTrue(judgePoint24(intArrayOf(4, 1, 8, 7)))
    assertFalse(judgePoint24(intArrayOf(1, 2, 1, 2)))
  }
}

