package problems

fun minimumOneBitOperations(n: Int): Int {
    var result = n
    var temp = n
    while (temp > 0) {
        temp = temp shr 1
        result = result xor temp
    }
    return result
}
