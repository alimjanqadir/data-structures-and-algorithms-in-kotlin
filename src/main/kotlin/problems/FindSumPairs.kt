package problems

class FindSumPairs(
    private val firstArray: IntArray,          // immutable nums1
    private val secondArray: IntArray          // mutable nums2
) {

    /** Frequency of each value in firstArray – built once. */
    private val countInFirst = HashMap<Int, Int>()

    /** Frequency of each value in secondArray – kept in sync with every add(). */
    private val countInSecond = HashMap<Int, Int>()

    init {
        // Build initial frequency tables.
        for (value in firstArray) {
            countInFirst[value] = (countInFirst[value] ?: 0) + 1
        }
        for (value in secondArray) {
            countInSecond[value] = (countInSecond[value] ?: 0) + 1
        }
    }

    /**
     * Adds [delta] to secondArray[index] and updates the frequency table in O(1).
     */
    fun add(index: Int, delta: Int) {
        val oldValue = secondArray[index]
        val newValue = oldValue + delta
        secondArray[index] = newValue

        // Decrease count of the old value.
        countInSecond[oldValue] = countInSecond.getValue(oldValue) - 1
        if (countInSecond[oldValue] == 0) {
            countInSecond.remove(oldValue)
        }

        // Increase count of the new value.
        countInSecond[newValue] = (countInSecond[newValue] ?: 0) + 1
    }

    /**
     * Returns the number of index pairs (i, j) whose sum equals [targetSum].
     * Runs in O(U₁) where U₁ is the number of distinct values in firstArray.
     */
    fun count(targetSum: Int): Int {
        var pairCount = 0
        for ((valueInFirst, frequencyInFirst) in countInFirst) {
            val complement = targetSum - valueInFirst
            val frequencyInSecond = countInSecond[complement] ?: 0
            // Each occurrence in first can pair with each occurrence in second.
            pairCount += frequencyInFirst * frequencyInSecond
        }
        return pairCount
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * var obj = FindSumPairs(nums1, nums2)
 * obj.add(index,`val`)
 * var param_2 = obj.count(tot)
 */
