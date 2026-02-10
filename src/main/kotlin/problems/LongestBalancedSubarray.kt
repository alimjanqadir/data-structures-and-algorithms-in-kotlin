package problems

fun longestBalanced(nums: IntArray): Int {
    val arrayLength = nums.size
    var longestLength = 0

    for (startIndex in 0 until arrayLength) {
        val distinctEvenValues = mutableSetOf<Int>()
        val distinctOddValues = mutableSetOf<Int>()

        var endIndex = startIndex
        while (endIndex < arrayLength) {
            val currentValue = nums[endIndex]

            if (currentValue % 2 == 0) {
                distinctEvenValues.add(currentValue)
            } else {
                distinctOddValues.add(currentValue)
            }

            if (distinctEvenValues.size == distinctOddValues.size) {
                val currentLength = endIndex - startIndex + 1
                if (currentLength > longestLength) {
                    longestLength = currentLength
                }
            }

            endIndex = endIndex + 1
        }
    }

    return longestLength
}
