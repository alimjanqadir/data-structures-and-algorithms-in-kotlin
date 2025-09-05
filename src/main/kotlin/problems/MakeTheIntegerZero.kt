package problems

fun makeTheIntegerZero(num1: Int, num2: Int): Int {
  val a = num1.toLong()
  val b = num2.toLong()

  for (operationsCount in 1..60) {
    val requiredSum = a - b * operationsCount
    if (requiredSum < operationsCount) continue
    val bitCount = java.lang.Long.bitCount(requiredSum)
    if (bitCount <= operationsCount) return operationsCount
  }
  return -1
}

