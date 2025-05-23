import kotlin.math.max // Or import kotlin.math.maxOf for Long

fun maximumValueSum(nums: IntArray, k: Int, edges: Array<IntArray>): Long {
    var dpEven = 0L
    var dpOdd = Long.MIN_VALUE // Represents an impossible/unreached state initially

    for (numValueInt in nums) {
        val numOriginal = numValueInt.toLong()
        val numXored = (numValueInt xor k).toLong()

        val prevDpEven = dpEven
        val prevDpOdd = dpOdd

        // Calculate the next dpEven state
        // Option 1: Current node NOT xored (previous must be even)
        val nextDpEvenOpt1 = prevDpEven + numOriginal
        // Option 2: Current node IS xored (previous must be odd)
        //            If prevDpOdd is MIN_VALUE, this path is effectively impossible
        val nextDpEvenOpt2 = if (prevDpOdd == Long.MIN_VALUE) Long.MIN_VALUE else prevDpOdd + numXored
        dpEven = max(nextDpEvenOpt1, nextDpEvenOpt2)

        // Calculate the next dpOdd state
        // Option 1: Current node NOT xored (previous must be odd)
        val nextDpOddOpt1 = if (prevDpOdd == Long.MIN_VALUE) Long.MIN_VALUE else prevDpOdd + numOriginal
        // Option 2: Current node IS xored (previous must be even)
        val nextDpOddOpt2 = prevDpEven + numXored // prevDpEven always starts valid
        dpOdd = max(nextDpOddOpt1, nextDpOddOpt2)
    }


    return dpEven
}
