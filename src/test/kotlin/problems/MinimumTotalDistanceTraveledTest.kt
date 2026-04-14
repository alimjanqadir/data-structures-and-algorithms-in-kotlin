package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class MinimumTotalDistanceTraveledTest {

    @Test
    fun testExample1() {
        val robot = listOf(0, 4, 6)
        val factory = arrayOf(
            intArrayOf(2, 2),
            intArrayOf(6, 2)
        )
        assertEquals(4L, minimumTotalDistance(robot, factory))
    }

    @Test
    fun testExample2() {
        val robot = listOf(1, -1)
        val factory = arrayOf(
            intArrayOf(-2, 1),
            intArrayOf(2, 1)
        )
        assertEquals(2L, minimumTotalDistance(robot, factory))
    }

    @Test
    fun testSingleRobotSingleFactory() {
        val robot = listOf(5)
        val factory = arrayOf(intArrayOf(10, 1))
        assertEquals(5L, minimumTotalDistance(robot, factory))
    }

    @Test
    fun testMultipleRobotsOneFactoryWithCapacity() {
        val robot = listOf(1, 2, 3)
        val factory = arrayOf(intArrayOf(5, 3))
        // All 3 robots go to factory at 5
        // |1-5| + |2-5| + |3-5| = 4 + 3 + 2 = 9
        assertEquals(9L, minimumTotalDistance(robot, factory))
    }

    @Test
    fun testRobotsNeedToSplitAcrossFactories() {
        val robot = listOf(1, 2, 3, 4, 5)
        val factory = arrayOf(
            intArrayOf(2, 2),
            intArrayOf(5, 2)
        )
        // Factory at 2 takes 2 robots, factory at 5 takes 2 robots
        // One robot left but no capacity - this is an invalid case per problem constraints
        // Actually, problem guarantees enough capacity
        val factoryWithEnoughCapacity = arrayOf(
            intArrayOf(2, 2),
            intArrayOf(5, 3)
        )
        // Optimal: robots 1,2 -> factory 2, robots 3,4,5 -> factory 5
        // |1-2| + |2-2| + |3-5| + |4-5| + |5-5| = 1 + 0 + 2 + 1 + 0 = 4
        assertEquals(4L, minimumTotalDistance(robot, factoryWithEnoughCapacity))
    }

    @Test
    fun testNegativePositions() {
        val robot = listOf(-10, -5, 0, 5, 10)
        val factory = arrayOf(
            intArrayOf(-5, 2),
            intArrayOf(5, 3)
        )
        // robots -10, -5 -> factory -5, robots 0, 5, 10 -> factory 5
        // |-10-(-5)| + |-5-(-5)| + |0-5| + |5-5| + |10-5| = 5 + 0 + 5 + 0 + 5 = 15
        assertEquals(15L, minimumTotalDistance(robot, factory))
    }

    @Test
    fun testAllRobotsAtSamePosition() {
        val robot = listOf(5, 5, 5, 5)
        val factory = arrayOf(
            intArrayOf(0, 2),
            intArrayOf(10, 2)
        )
        // 2 robots go to factory at 0, 2 robots go to factory at 10
        // 2 * |5-0| + 2 * |5-10| = 2*5 + 2*5 = 20
        assertEquals(20L, minimumTotalDistance(robot, factory))
    }

    @Test
    fun testFactoriesAtSamePosition() {
        val robot = listOf(1, 2, 3, 4)
        val factory = arrayOf(
            intArrayOf(5, 1),
            intArrayOf(5, 3)
        )
        // Both factories at position 5, combined capacity 4
        // |1-5| + |2-5| + |3-5| + |4-5| = 4 + 3 + 2 + 1 = 10
        assertEquals(10L, minimumTotalDistance(robot, factory))
    }

    @Test
    fun testLargeDistance() {
        val robot = listOf(0, 1000000)
        val factory = arrayOf(
            intArrayOf(500000, 2)
        )
        // Both robots go to middle factory
        // |0-500000| + |1000000-500000| = 500000 + 500000 = 1000000
        assertEquals(1000000L, minimumTotalDistance(robot, factory))
    }

    @Test
    fun testManySmallFactories() {
        val robot = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val factory = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 1),
            intArrayOf(3, 1),
            intArrayOf(4, 1),
            intArrayOf(5, 1),
            intArrayOf(6, 1),
            intArrayOf(7, 1),
            intArrayOf(8, 1),
            intArrayOf(9, 1),
            intArrayOf(10, 1)
        )
        // Each robot goes to its matching factory, total distance 0
        assertEquals(0L, minimumTotalDistance(robot, factory))
    }
}
