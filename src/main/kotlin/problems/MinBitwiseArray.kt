package problems

/**
 * Solution for the minimum bitwise array problem.
 * For each number in the input list, finds the smallest non-negative integer x such that x | (x + 1) equals the number.
 * If no such x exists, returns -1 for that position.
 */
fun minBitwiseArray(nums: List<Int>): IntArray {
    val result = IntArray(nums.size)

    for (index in nums.indices) {
        val target = nums[index]
        var answer = -1

        for (candidate in 0 until target) {
            if ((candidate or (candidate + 1)) == target) {
                answer = candidate
                break
            }
        }

        result[index] = answer
    }

    return result
}
