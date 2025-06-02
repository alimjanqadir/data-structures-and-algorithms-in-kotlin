package problems

fun candy(ratings: IntArray): Int {
    if (ratings.isEmpty()) return 0
    
    var totalCandies = 1  // First child
    var upLen = 0         // Length of increasing run
    var downLen = 0       // Length of decreasing run
    var peakLen = 0       // Length of ascent before descent
    
    for (i in 1 until ratings.size) {
        when {
            ratings[i] > ratings[i - 1] -> {
                upLen += 1
                peakLen = upLen
                downLen = 0
                totalCandies += 1 + upLen
            }
            ratings[i] == ratings[i - 1] -> {
                upLen = 0
                downLen = 0
                peakLen = 0
                totalCandies += 1
            }
            else -> {
                downLen += 1
                upLen = 0
                val correction = if (downLen <= peakLen) 1 else 0
                totalCandies += 1 + downLen - correction
            }
        }
    }
    return totalCandies
}
