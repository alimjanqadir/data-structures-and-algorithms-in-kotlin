fun numEquivDominoPairs(dominoes: Array<IntArray>): Int {
    val frequencyByKey = IntArray(100)                // keys 11..99 only
    var totalPairs = 0

    for (domino in dominoes) {
        val firstEnd = domino[0]
        val secondEnd = domino[1]

        val smallerEnd = minOf(firstEnd, secondEnd)
        val largerEnd  = maxOf(firstEnd, secondEnd)
        val key = smallerEnd * 10 + largerEnd         // canonical key

        val previousCount = frequencyByKey[key]
        totalPairs += previousCount                   // +k new pairs
        frequencyByKey[key] = previousCount + 1       // update count
    }
    return totalPairs
}
