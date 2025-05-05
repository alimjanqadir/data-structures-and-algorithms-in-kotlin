import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumTilingsTest {
    @Test
    fun testNumTilings() {
        assertEquals(1, numTilings(0))
        assertEquals(1, numTilings(1))
        assertEquals(2, numTilings(2))
        assertEquals(5, numTilings(3))
        assertEquals(11, numTilings(4))
        assertEquals(24, numTilings(5))
    }
}
