import java.util.PriorityQueue

class Solution {
    fun maxTotalValue(nums: IntArray, k: Int): Long {
        val sparseTable = RangeSparseTable(nums)
        val candidateHeap = PriorityQueue<SubarrayCandidate>(
            compareByDescending<SubarrayCandidate> { it.value }
        )

        val lastIndex = nums.size - 1

        var startIndex = 0
        while (startIndex < nums.size) {
            candidateHeap.add(
                SubarrayCandidate(
                    sparseTable.rangeValue(startIndex, lastIndex),
                    startIndex,
                    lastIndex
                )
            )
            startIndex += 1
        }

        var answer = 0L
        var remainingSelections = k

        while (remainingSelections > 0) {
            val candidate = candidateHeap.poll()

            answer += candidate.value

            if (candidate.endIndex > candidate.startIndex) {
                val nextEndIndex = candidate.endIndex - 1

                candidateHeap.add(
                    SubarrayCandidate(
                        sparseTable.rangeValue(
                            candidate.startIndex,
                            nextEndIndex
                        ),
                        candidate.startIndex,
                        nextEndIndex
                    )
                )
            }

            remainingSelections -= 1
        }

        return answer
    }

    private data class SubarrayCandidate(
        val value: Long,
        val startIndex: Int,
        val endIndex: Int
    )

    private class RangeSparseTable(nums: IntArray) {
        private val logarithm = IntArray(nums.size + 1)
        private val maximumTable: Array<IntArray>
        private val minimumTable: Array<IntArray>

        init {
            var length = 2
            while (length <= nums.size) {
                logarithm[length] = logarithm[length / 2] + 1
                length += 1
            }

            val levelCount = logarithm[nums.size] + 1

            maximumTable = Array(levelCount) { IntArray(nums.size) }
            minimumTable = Array(levelCount) { IntArray(nums.size) }

            var index = 0
            while (index < nums.size) {
                maximumTable[0][index] = nums[index]
                minimumTable[0][index] = nums[index]
                index += 1
            }

            var level = 1
            while (level < levelCount) {
                val segmentLength = 1 shl level
                val halfLength = segmentLength shr 1
                val limit = nums.size - segmentLength + 1

                var startIndex = 0
                while (startIndex < limit) {
                    maximumTable[level][startIndex] = maxOf(
                        maximumTable[level - 1][startIndex],
                        maximumTable[level - 1][startIndex + halfLength]
                    )

                    minimumTable[level][startIndex] = minOf(
                        minimumTable[level - 1][startIndex],
                        minimumTable[level - 1][startIndex + halfLength]
                    )

                    startIndex += 1
                }

                level += 1
            }
        }

        fun rangeValue(leftIndex: Int, rightIndex: Int): Long {
            val length = rightIndex - leftIndex + 1
            val level = logarithm[length]
            val segmentLength = 1 shl level

            val maximum = maxOf(
                maximumTable[level][leftIndex],
                maximumTable[level][rightIndex - segmentLength + 1]
            )

            val minimum = minOf(
                minimumTable[level][leftIndex],
                minimumTable[level][rightIndex - segmentLength + 1]
            )

            return maximum.toLong() - minimum.toLong()
        }
    }
}