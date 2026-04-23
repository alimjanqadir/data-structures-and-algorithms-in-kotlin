package problems

/**
 * LeetCode 2615 - Sum of Distances
 * 
 * The core idea is to group indices by value, then compute contributions efficiently using prefix sums.
 * 
 * For each value v, suppose its indices are: i₀, i₁, i₂, ..., iₖ
 * For any position i = iₘ, we want: sum(|iₘ - i₀| + |iₘ - i₁| + ... + |iₘ - iₖ|)
 * 
 * Split into two parts:
 * - Left side: indices before iₘ
 * - Right side: indices after iₘ
 * 
 * Formula:
 * Let prefixSum[j] = sum of indices from 0 → j, total indices count = k + 1
 * For position m:
 * Left contribution: iₘ * m - prefixSum[m - 1]
 * Right contribution: (prefixSum[k] - prefixSum[m]) - iₘ * (k - m)
 * 
 * Strategy:
 * 1. Group indices by value using a map
 * 2. For each group: build prefix sums and compute result for each index using the formula
 * This gives O(n) time overall.
 */
class SumOfDistances {
    fun distance(nums: IntArray): LongArray {
        val valueToIndices = HashMap<Int, MutableList<Int>>()
        
        // Step 1: group indices
        for (index in nums.indices) {
            valueToIndices
                .computeIfAbsent(nums[index]) { mutableListOf() }
                .add(index)
        }
        
        val result = LongArray(nums.size)
        
        // Step 2: process each group
        for (indices in valueToIndices.values) {
            val size = indices.size
            
            val prefixSum = LongArray(size)
            prefixSum[0] = indices[0].toLong()
            
            for (position in 1 until size) {
                prefixSum[position] = prefixSum[position - 1] + indices[position]
            }
            
            for (position in indices.indices) {
                val currentIndex = indices[position]
                
                val leftContribution =
                    currentIndex.toLong() * position -
                    (if (position > 0) prefixSum[position - 1] else 0L)
                
                val rightContribution =
                    (prefixSum[size - 1] - prefixSum[position]) -
                    currentIndex.toLong() * (size - position - 1)
                
                result[currentIndex] = leftContribution + rightContribution
            }
        }
        
        return result
    }
}
