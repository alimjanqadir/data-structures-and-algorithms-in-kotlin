package problems

fun minNumberOperations(target: IntArray): Int {
  val length = target.size
  if (length == 0) return 0

  var operations = target[0]
  for (position in 1 until length) {
    val increase = target[position] - target[position - 1]
    if (increase > 0) {
      operations += increase
    }
  }
  return operations
}
