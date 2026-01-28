package problems

class Solution {
    fun minimumAbsDifference(arr: IntArray): List<List<Int>> {
        arr.sort()

        var minimumDifference = Long.MAX_VALUE

        // First pass: find the minimum absolute difference
        for (index in 0 until arr.size - 1) {
            val currentDifference =
                arr[index + 1].toLong() - arr[index].toLong()

            if (currentDifference < minimumDifference) {
                minimumDifference = currentDifference
            }
        }

        val result = mutableListOf<List<Int>>()

        // Second pass: collect all pairs with that minimum difference
        for (index in 0 until arr.size - 1) {
            val currentDifference =
                arr[index + 1].toLong() - arr[index].toLong()

            if (currentDifference == minimumDifference) {
                result.add(listOf(arr[index], arr[index + 1]))
            }
        }

        return result
    }
}
