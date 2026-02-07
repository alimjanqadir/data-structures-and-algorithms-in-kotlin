import problems.pushDominoes
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PushDominoesTest {
  @Test
  fun `test push dominoes`() {
    assertEquals("LL.RR.LLRRLL..", pushDominoes(".L.R...LR..L..") )
    assertEquals("RR.L", pushDominoes("RR.L") )
    assertEquals("RR.L", pushDominoes("RR.L") )
    assertEquals("L", pushDominoes("L") )
    assertEquals("R", pushDominoes("R") )
    assertEquals(".", pushDominoes(".") )
  }
}
