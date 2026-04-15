package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class ShortestDistanceToTargetStringInACircularArrayTest {

    @Test
    fun testExample1() {
        // LeetCode example 1: target "a" at index 4, start at index 1
        // Going right: (4-1+8)%8 = 3, Going left: (1-4+8)%8 = 5
        // Minimum is 3
        val words = arrayOf("hello", "i", "am", "leetcode", "hello")
        assertEquals(1, closestTarget(words, "hello", 3))
    }

    @Test
    fun testExample2() {
        // LeetCode example 2: target "a" doesn't exist
        val words = arrayOf("a", "b", "c")
        assertEquals(-1, closestTarget(words, "d", 0))
    }

    @Test
    fun testExample3() {
        // LeetCode example 3: target "aab" at indices 0 and 2, start at index 0
        // Index 0: distance = 0 (target is at startIndex)
        // Index 2: right=(2-0+4)%4=2, left=(0-2+4)%4=2, min=2
        // Result: 0
        val words = arrayOf("aab", "aac", "aab", "aac")
        assertEquals(0, closestTarget(words, "aab", 0))
    }

    @Test
    fun testSingleElementMatch() {
        val words = arrayOf("target")
        assertEquals(0, closestTarget(words, "target", 0))
    }

    @Test
    fun testSingleElementNoMatch() {
        val words = arrayOf("notarget")
        assertEquals(-1, closestTarget(words, "target", 0))
    }

    @Test
    fun testTargetAtStartIndex() {
        // Target is at startIndex, distance should be 0
        val words = arrayOf("a", "b", "c", "d", "e")
        assertEquals(0, closestTarget(words, "c", 2))
    }

    @Test
    fun testCircularLeftShorter() {
        // Array: ["a", "b", "target", "d", "e"], start at index 4, target at index 2
        // Going right: (2-4+5)%5 = 3
        // Going left: (4-2+5)%5 = 2
        // Minimum is 2 (going left)
        val words = arrayOf("a", "b", "target", "d", "e")
        assertEquals(2, closestTarget(words, "target", 4))
    }

    @Test
    fun testCircularRightShorter() {
        // Array: ["a", "b", "target", "d", "e"], start at index 0, target at index 2
        // Going right: (2-0+5)%5 = 2
        // Going left: (0-2+5)%5 = 3
        // Minimum is 2 (going right)
        val words = arrayOf("a", "b", "target", "d", "e")
        assertEquals(2, closestTarget(words, "target", 0))
    }

    @Test
    fun testMultipleTargetsPickClosest() {
        // Multiple targets, should pick the closest one
        // ["target", "x", "x", "target", "x"], start at index 2
        // Target at 0: right=(0-2+5)%5=3, left=(2-0+5)%5=2, min=2
        // Target at 3: right=(3-2+5)%5=1, left=(2-3+5)%5=4, min=1
        // Result: 1
        val words = arrayOf("target", "x", "x", "target", "x")
        assertEquals(1, closestTarget(words, "target", 2))
    }

    @Test
    fun testEquidistantTargets() {
        // Start at index 2, targets at indices 0 and 4 in a 5-element array
        // Both are distance 2 (circular)
        val words = arrayOf("target", "x", "x", "x", "target")
        assertEquals(2, closestTarget(words, "target", 2))
    }

    @Test
    fun testLargeCircularDistance() {
        // Test wrap-around in large array
        // ["a", "b", ..., "target"], start at index 0, target at last index
        val words = Array(100) { if (it == 99) "target" else "x" }
        assertEquals(1, closestTarget(words, "target", 0))
    }
}
