package problems

fun xorAfterQueries(nums: IntArray, queries: Array<IntArray>): Int {
    val mod = 1_000_000_007L

    for (query in queries) {
        val leftIndex = query[0]
        val rightIndex = query[1]
        val stepSize = query[2]
        val multiplier = query[3].toLong()

        var currentIndex = leftIndex
        while (currentIndex <= rightIndex) {
            nums[currentIndex] = ((nums[currentIndex].toLong() * multiplier) % mod).toInt()
            currentIndex += stepSize
        }
    }

    var xorResult = 0
    for (value in nums) {
        xorResult = xorResult xor value
    }

    return xorResult
}
