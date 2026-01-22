package problems

fun minimumPairRemoval(nums: IntArray): Int {
    val array = nums.toMutableList()
    var operations = 0

    fun isNonDecreasing(): Boolean {
        for (index in 1 until array.size) {
            if (array[index] < array[index - 1]) return false
        }
        return true
    }

    while (!isNonDecreasing()) {
        var minimumSum = Int.MAX_VALUE
        var mergeIndex = 0

        for (index in 0 until array.size - 1) {
            val currentSum = array[index] + array[index + 1]
            if (currentSum < minimumSum) {
                minimumSum = currentSum
                mergeIndex = index
            }
        }

        val mergedValue = array[mergeIndex] + array[mergeIndex + 1]
        array[mergeIndex] = mergedValue
        array.removeAt(mergeIndex + 1)

        operations++
    }

    return operations
}
