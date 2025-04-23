package problems

fun countCompleteSubarrays(nums: IntArray): Int {
    val map = mutableMapOf<Int, Int>()
    for (num in nums) {
        map[num] = map.getOrDefault(num, 0) + 1
    }
    val distinct = map.size
    var result = 0
    var left = 0
    var count = 0
    map.clear()
    for (right in nums.indices) {
        map[nums[right]] = map.getOrDefault(nums[right], 0) + 1
        if (map[nums[right]]!! == 1) count++
        while (count >= distinct) {
            map[nums[left]] = map[nums[left]]!! - 1
            if (map[nums[left]]!! == 0) {
                map.remove(nums[left])
                count--
            }
            left++
        }
        result += left
    }
    return result
}
