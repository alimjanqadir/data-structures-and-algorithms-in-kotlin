fun minimumCost(nums: IntArray): Int {
    val arrayLength = nums.size
    var minimumTotalCost = Int.MAX_VALUE

    for (firstCutIndex in 1 until arrayLength - 1) {
        for (secondCutIndex in firstCutIndex + 1 until arrayLength) {
            val totalCost =
                nums[0] +
                nums[firstCutIndex] +
                nums[secondCutIndex]

            if (totalCost < minimumTotalCost) {
                minimumTotalCost = totalCost
            }
        }
    }

    return minimumTotalCost
}
