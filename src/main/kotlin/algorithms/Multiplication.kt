package algorithms

@Suppress("UnnecessaryVariable")
fun naive(a: Int, b: Int): Int {
  val x = a
  var y = b
  var z = 0
  while (y > 0) {
    z += x
    y -= 1
  }
  return z
}

fun russian(a: Int, b: Int): Int {
  var x = a
  var y = b
  var z = 0
  while (y > 0) {
    if (y % 2 == 1) {
      z += x
    }
    y = y shr 1
    x = x shl 1
  }
  return z
}

fun russianRecursive(a: Int, b: Int): Int {
  if (a == 0) return 0
  if (a % 2 == 0) return 2 * russianRecursive(a / 2, b)
  return b + 2 * russianRecursive((a - 1) / 2, b)
}


fun main() {
  println(naive(11, 2))
  println(russian(11, 2))
  println(russianRecursive(11, 2))
}