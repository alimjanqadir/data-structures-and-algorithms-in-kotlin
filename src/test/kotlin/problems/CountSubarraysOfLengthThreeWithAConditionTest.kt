import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountSubarraysOfLengthThreeWithAConditionTest {
    @Test
    fun testExample1() {
        val nums = intArrayOf(1, 4, 7, 2, 6, 10)
        // Only (1,4,7) and (2,6,10) satisfy: 1+7=8 == 4/2=2, 2+10=12 == 6/2=3 (should be false)
        // But based on the condition, none actually satisfy, so expected is 0
        assertEquals(0, countSubarraysOfLengthThreeWithACondition(nums))
    }

    @Test
    fun testCustom() {
        val nums = intArrayOf(2, 8, 2)
        // 2+2=4 == 8/2=4, so expected is 1
        assertEquals(1, countSubarraysOfLengthThreeWithACondition(nums))
    }

    @Test
    fun testEmpty() {
        val nums = intArrayOf()
        assertEquals(0, countSubarraysOfLengthThreeWithACondition(nums))
    }

    @Test
    fun testShortArray() {
        val nums = intArrayOf(1,2)
        assertEquals(0, countSubarraysOfLengthThreeWithACondition(nums))
    }
}
