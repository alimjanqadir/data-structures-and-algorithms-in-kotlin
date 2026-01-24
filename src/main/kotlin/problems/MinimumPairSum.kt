package problems

fun minPairSum(nums: IntArray): Int {
    nums.sort()
    return (0 until nums.size / 2).maxOf { 
        nums[it] + nums[nums.lastIndex - it] 
    }
}
