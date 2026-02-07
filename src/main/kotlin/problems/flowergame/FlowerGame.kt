package problems

fun flowerGame(n: Int, m: Int): Long {
    val oddCountN = ((n + 1) / 2).toLong()
    val evenCountN = (n / 2).toLong()
    val oddCountM = ((m + 1) / 2).toLong()
    val evenCountM = (m / 2).toLong()
    return oddCountN * evenCountM + evenCountN * oddCountM
}
