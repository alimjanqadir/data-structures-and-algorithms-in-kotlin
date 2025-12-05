package problems

fun countPartitions(nums: IntArray): Int {
    val totalSum = nums.sum()
    return if (totalSum % 2 == 0) nums.size - 1 else 0
}
