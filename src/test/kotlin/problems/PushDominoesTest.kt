import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PushDominoesTest {
    private val solution = Solution()

    @Test
    fun `test push dominoes`() {
        assertEquals("LL.RR.LLRRLL..", solution.pushDominoes(".L.R...LR..L..") )
        assertEquals("RR.L", solution.pushDominoes("RR.L") )
        assertEquals("RR.L", solution.pushDominoes("RR.L") )
        assertEquals("L", solution.pushDominoes("L") )
        assertEquals("R", solution.pushDominoes("R") )
        assertEquals(".", solution.pushDominoes(".") )
    }
}
