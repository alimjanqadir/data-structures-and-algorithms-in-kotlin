package problems

/**
 * LeetCode 2808. Minimum Equal Sum After Replacing Zeros
 * https://leetcode.com/problems/minimum-equal-sum-after-replacing-zeros/
 */
fun minimumEqualSumAfterReplacingZeros(nums1: IntArray, nums2: IntArray): Long {
    // ---- pass 1 : gather base sums and zero counts ----
    var baseSum1 = 0L
    var zeroCnt1 = 0
    for (number in nums1) {
        if (number == 0) zeroCnt1++ else baseSum1 += number
    }

    var baseSum2 = 0L
    var zeroCnt2 = 0
    for (number in nums2) {
        if (number == 0) zeroCnt2++ else baseSum2 += number
    }

    // ---- personal minima ----
    val minPossible1 = baseSum1 + zeroCnt1    // every zero becomes 1
    val minPossible2 = baseSum2 + zeroCnt2

    // ---- decide feasibility & answer ----
    return when {
        minPossible1 == minPossible2 -> minPossible1          // already aligned
        minPossible1 < minPossible2 ->
            if (zeroCnt1 == 0) -1L else minPossible2          // side 1 cannot climb
        else /* minPossible2 < minPossible1 */ ->
            if (zeroCnt2 == 0) -1L else minPossible1          // side 2 cannot climb
    }
}
