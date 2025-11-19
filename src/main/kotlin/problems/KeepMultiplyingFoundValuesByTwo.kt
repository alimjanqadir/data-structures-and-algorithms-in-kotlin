package problems

fun findFinalValue(nums: IntArray, original: Int): Int {
    var cur = original
    while (true) {
        var found = false
        for (x in nums) {
            if (x == cur) {
                found = true
                break
            }
        }
        if (!found) break
        cur *= 2
    }
    return cur
}
