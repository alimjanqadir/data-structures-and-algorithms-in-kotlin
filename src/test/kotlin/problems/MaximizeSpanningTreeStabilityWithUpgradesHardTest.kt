package problems

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class MaximizeSpanningTreeStabilityWithUpgradesHardTest {

    @Test
    fun `test basic example`() {
        val edges = arrayOf(
            intArrayOf(0, 1, 5, 1),
            intArrayOf(1, 2, 3, 0),
            intArrayOf(2, 3, 4, 0)
        )
        assertEquals(4, maxStability(4, edges, 1))
    }

    @Test
    fun `test impossible due to mandatory edges cycle`() {
        val edges = arrayOf(
            intArrayOf(0, 1, 5, 1),
            intArrayOf(1, 2, 5, 1),
            intArrayOf(2, 0, 5, 1)
        )
        assertEquals(-1, maxStability(3, edges, 1))
    }

    @Test
    fun `test impossible due to disconnected graph`() {
        val edges = arrayOf(
            intArrayOf(0, 1, 5, 1),
            intArrayOf(2, 3, 4, 0)
        )
        assertEquals(-1, maxStability(4, edges, 2))
    }

    @Test
    fun `test no upgrades needed`() {
        val edges = arrayOf(
            intArrayOf(0, 1, 10, 1),
            intArrayOf(1, 2, 8, 0),
            intArrayOf(2, 3, 6, 0)
        )
        assertEquals(6, maxStability(4, edges, 0))
    }

    @Test
    fun `test all edges need upgrades`() {
        val edges = arrayOf(
            intArrayOf(0, 1, 2, 0),
            intArrayOf(1, 2, 3, 0),
            intArrayOf(2, 3, 4, 0)
        )
        assertEquals(4, maxStability(4, edges, 3))
    }

    @Test
    fun `test insufficient upgrades`() {
        val edges = arrayOf(
            intArrayOf(0, 1, 1, 0),
            intArrayOf(1, 2, 1, 0),
            intArrayOf(2, 3, 10, 0)
        )
        assertEquals(1, maxStability(4, edges, 1))
    }

    @Test
    fun `test single node`() {
        val edges = emptyArray<IntArray>()
        assertEquals(1, maxStability(1, edges, 0))
    }

    @Test
    fun `test two nodes mandatory edge`() {
        val edges = arrayOf(
            intArrayOf(0, 1, 7, 1)
        )
        assertEquals(7, maxStability(2, edges, 0))
    }

    @Test
    fun `test complex graph with mixed edges`() {
        val edges = arrayOf(
            intArrayOf(0, 1, 5, 1),
            intArrayOf(1, 2, 2, 0),
            intArrayOf(2, 3, 3, 0),
            intArrayOf(3, 4, 1, 0),
            intArrayOf(4, 0, 4, 0)
        )
        assertEquals(4, maxStability(5, edges, 2))
    }

    @Test
    fun `test edge upgrade exactly at threshold`() {
        val edges = arrayOf(
            intArrayOf(0, 1, 4, 1),
            intArrayOf(1, 2, 3, 0),
            intArrayOf(2, 3, 2, 0)
        )
        assertEquals(3, maxStability(4, edges, 1))
    }
}
