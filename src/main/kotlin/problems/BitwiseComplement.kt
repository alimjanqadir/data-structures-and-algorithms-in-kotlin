package problems

fun bitwiseComplement(n: Int): Int {
    if (n == 0) {
        return 1
    }

    var mask = 1

    while (mask < n) {
        mask = (mask shl 1) or 1
    }

    return n xor mask
}
