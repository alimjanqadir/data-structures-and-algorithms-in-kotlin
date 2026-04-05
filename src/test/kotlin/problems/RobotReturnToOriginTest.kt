package problems

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class RobotReturnToOriginTest {

  @Test
  fun testJudgeCircleExample1() {
    assertTrue(judgeCircle("UD"))
  }

  @Test
  fun testJudgeCircleExample2() {
    assertFalse(judgeCircle("LL"))
  }

  @Test
  fun testJudgeCircleEmpty() {
    assertTrue(judgeCircle(""))
  }

  @Test
  fun testJudgeCircleSquare() {
    assertTrue(judgeCircle("UDLR"))
  }

  @Test
  fun testJudgeCircleComplex() {
    assertTrue(judgeCircle("UUDDLLRR"))
  }

  @Test
  fun testJudgeCircleNotReturn() {
    assertFalse(judgeCircle("UUU"))
  }
}
