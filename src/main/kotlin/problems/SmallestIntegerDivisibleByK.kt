package problems

fun smallestRepunitDivByK(k: Int): Int {
    if (k <= 0) return -1  // though constraints say k >= 1
    if (k == 1) return 1
    if (k % 2 == 0 || k % 5 == 0) return -1

    var rem = 0L
    for (len in 1..k) {
        rem = (rem * 10 + 1) % k
        if (rem == 0L) return len
    }
    return -1
}
