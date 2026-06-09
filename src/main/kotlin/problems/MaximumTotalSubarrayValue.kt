fun maxTotalValue(nums: IntArray, k: Int): Long {
    var minimumValue = Int.MAX_VALUE
    var maximumValue = Int.MIN_VALUE

    for (value in nums) {
        minimumValue = minOf(minimumValue, value)
        maximumValue = maxOf(maximumValue, value)
    }

    return (maximumValue.toLong() - minimumValue.toLong()) * k
}