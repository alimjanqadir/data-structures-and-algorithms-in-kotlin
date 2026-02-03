package problems

fun maxOperations(s: String): Int {
  val n = s.length
  var ans = 0
  var countOnes = 0
  var i = 0
  while (i < n) {
    if (s[i] == '0') {
      i++
      continue
    }
    // start of a '1' run
    while (i < n && s[i] == '1') {
      countOnes++
      i++
    }
    // if followed by '0's
    if (i < n) {
      ans += countOnes
    }
  }
  return ans
}
