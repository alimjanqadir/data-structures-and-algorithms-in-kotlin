package problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxTaskAssignmentTest {

    @Test
    fun testExample1() {
        val result = maxTaskAssign(
            taskStrengths = intArrayOf(3, 2, 1),
            workerStrengths = intArrayOf(0, 3, 3),
            availablePills = 1,
            pillBoost = 1
        )
        assertEquals(3, result)
    }

    @Test
    fun testExample2() {
        val result = maxTaskAssign(
            taskStrengths = intArrayOf(5, 4),
            workerStrengths = intArrayOf(0, 0, 0),
            availablePills = 1,
            pillBoost = 5
        )
        assertEquals(1, result)
    }

    @Test
    fun testNoPills() {
        val result = maxTaskAssign(
            taskStrengths = intArrayOf(10, 15, 30),
            workerStrengths = intArrayOf(0, 10, 10, 10, 10),
            availablePills = 0,
            pillBoost = 10
        )
        assertEquals(1, result)  // Only one task (10) can be completed without pills
    }

    @Test
    fun testAllTasks() {
        val result = maxTaskAssign(
            taskStrengths = intArrayOf(1, 2, 3),
            workerStrengths = intArrayOf(1, 2, 3),
            availablePills = 3,
            pillBoost = 1
        )
        assertEquals(3, result)
    }

    @Test
    fun testNoTasks() {
        val result = maxTaskAssign(
            taskStrengths = intArrayOf(10, 20, 30),
            workerStrengths = intArrayOf(0, 0, 0),
            availablePills = 2,
            pillBoost = 5
        )
        assertEquals(0, result)  // No tasks can be completed with the given workers and pills
    }
}
