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

