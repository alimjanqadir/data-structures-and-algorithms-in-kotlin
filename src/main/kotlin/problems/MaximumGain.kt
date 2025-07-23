package problems

fun maximumGain(s: String, x: Int, y: Int): Int {
  val firstLeft: Char
  val firstRight: Char
  val firstScore: Int
  val secondLeft: Char
  val secondRight: Char
  val secondScore: Int

  if (x >= y) {
    firstLeft = 'a'
    firstRight = 'b'
    firstScore = x
    secondLeft = 'b'
    secondRight = 'a'
    secondScore = y
  } else {
    firstLeft = 'b'
    firstRight = 'a'
    firstScore = y
    secondLeft = 'a'
    secondRight = 'b'
    secondScore = x
  }

  val chars = s.toCharArray()
  var total = 0

  var write = 0
  for (read in chars.indices) {
    val c = chars[read]
    if (write > 0 && chars[write - 1] == firstLeft && c == firstRight) {
      write -= 1
      total += firstScore
    } else {
      chars[write] = c
      write += 1
    }
  }

  val remaining = write
  write = 0
  for (read in 0 until remaining) {
    val c = chars[read]
    if (write > 0 && chars[write - 1] == secondLeft && c == secondRight) {
      write -= 1
      total += secondScore
    } else {
      chars[write] = c
      write += 1
    }
  }

  return total
}
