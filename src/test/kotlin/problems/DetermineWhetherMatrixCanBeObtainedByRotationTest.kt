package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class DetermineWhetherMatrixCanBeObtainedByRotationTest {

    @Test
    fun testFindRotation() {
        // Test case 1: 90-degree rotation needed
        val mat1 = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0)
        )
        val target1 = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(0, 1)
        )
        assertEquals(true, findRotation(mat1, target1))

        // Test case 2: No rotation can make them equal
        val mat2 = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 1)
        )
        val target2 = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(0, 1)
        )
        assertEquals(false, findRotation(mat2, target2))

        // Test case 3: Already equal (0-degree rotation)
        val mat3 = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(1, 1, 1)
        )
        val target3 = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(1, 1, 1)
        )
        assertEquals(true, findRotation(mat3, target3))

        // Test case 4: 180-degree rotation needed
        val mat4 = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(1, 1, 1)
        )
        val target4 = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(0, 1, 0),
            intArrayOf(0, 0, 0)
        )
        assertEquals(true, findRotation(mat4, target4))

        // Test case 5: 270-degree rotation needed
        val mat5 = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4)
        )
        val target5 = arrayOf(
            intArrayOf(2, 4),
            intArrayOf(1, 3)
        )
        assertEquals(true, findRotation(mat5, target5))

        // Test case 6: Single element matrix
        val mat6 = arrayOf(
            intArrayOf(1)
        )
        val target6 = arrayOf(
            intArrayOf(1)
        )
        assertEquals(true, findRotation(mat6, target6))
    }
}
