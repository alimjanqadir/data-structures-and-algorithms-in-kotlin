package problems

fun countOperations(num1: Int, num2: Int): Int {
  var a = num1
  var b = num2
  var count = 0
  while (a > 0 && b > 0) {
    if (a >= b) {
      count += a / b
      a %= b
    } else {
      count += b / a
      b %= a
    }
  }
  return count
}
