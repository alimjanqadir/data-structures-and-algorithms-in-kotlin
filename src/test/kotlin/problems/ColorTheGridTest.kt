import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ColorTheGridTest {
    @Test
    fun testColorTheGrid() {
        // Test case 1: 1x1 grid
        assertEquals(3, colorTheGrid(1, 1))
        
        // Test case 2: 1x2 grid
        assertEquals(6, colorTheGrid(1, 2))
        
        // Test case 3: 2x2 grid
        assertEquals(6, colorTheGrid(2, 1))
        
        // Test case 4: 2x2 grid
        assertEquals(18, colorTheGrid(2, 2))
        
        // Test case 5: 3x2 grid
        assertEquals(54, colorTheGrid(3, 2))
    }
}
