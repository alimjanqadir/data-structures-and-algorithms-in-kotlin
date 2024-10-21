package problems

fun isHappyOptimized(n: Int): Boolean {
    val seen = mutableSetOf<Int>()
    var current = n

    while (current != 1 && current !in seen) {
        seen.add(current)
        current = sumOfSquaredDigits(current)
    }

    return current == 1
}

fun isHappyFunctional(n: Int): Boolean {
    tailrec fun isHappyRec(num: Int, seen: Set<Int>): Boolean = when {
        num == 1 -> true
        num in seen -> false
        else -> isHappyRec(sumOfSquaredDigits(num), seen + num)
    }

    return isHappyRec(n, emptySet())
}

fun sumOfSquaredDigits(n: Int): Int =
    n.toString().map { it.toString().toInt() }.sumOf { it * it }

fun main() {
    val testCases = listOf(
        1 to true,
        7 to true,
        10 to true,
        13 to true,
        19 to true,
        23 to true,
        28 to true,
        31 to true,
        32 to true,
        44 to true,
        49 to true,
        68 to true,
        70 to true,
        79 to true,
        82 to true,
        86 to true,
        91 to true,
        94 to true,
        97 to true,
        100 to true,
        2 to false,
        3 to false,
        4 to false,
        5 to false,
        6 to false,
        8 to false,
        9 to false,
        11 to false,
        12 to false,
        14 to false,
        15 to false,
        16 to false,
        17 to false,
        18 to false,
        20 to false
    )

    listOf(::isHappyOptimized, ::isHappyFunctional).forEach { isHappyFun ->
        testCases.forEachIndexed { index, (input, expected) ->
            val result = isHappyFun(input)
            assert(result == expected) { "Test case $index failed for ${isHappyFun.name}: input=$input, expected=$expected, got=$result" }
        }
        println("All tests passed for ${isHappyFun.name}")
    }
}