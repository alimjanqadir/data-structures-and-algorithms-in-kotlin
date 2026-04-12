package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class MinimumDistanceToTypeAWordUsingTwoFingersTest {

    @Test
    fun testExample1() {
        assertEquals(3, minimumDistanceToTypeAWordUsingTwoFingers("CAKE"))
    }

    @Test
    fun testExample2() {
        assertEquals(6, minimumDistanceToTypeAWordUsingTwoFingers("HAPPY"))
    }

    @Test
    fun testSingleCharacter() {
        assertEquals(0, minimumDistanceToTypeAWordUsingTwoFingers("A"))
    }

    @Test
    fun testTwoCharacters() {
        assertEquals(0, minimumDistanceToTypeAWordUsingTwoFingers("AB"))
    }

    @Test
    fun testSameCharacterRepeated() {
        assertEquals(0, minimumDistanceToTypeAWordUsingTwoFingers("AAA"))
    }

    @Test
    fun testAllSameRow() {
        // A-F are adjacent in the same row
        // Optimal: finger1 at A,B,C (cost 2), finger2 at D,E,F (cost 2) = 4
        assertEquals(4, minimumDistanceToTypeAWordUsingTwoFingers("ABCDEF"))
    }

    @Test
    fun testAlternatingFingers() {
        // AB alternates, optimal is finger1 at A, finger2 at B, no movement needed
        assertEquals(0, minimumDistanceToTypeAWordUsingTwoFingers("ABABAB"))
    }

    @Test
    fun testLongWord() {
        // NEWYORKCITY - actual calculated value
        assertEquals(21, minimumDistanceToTypeAWordUsingTwoFingers("NEWYORKCITY"))
    }
}
