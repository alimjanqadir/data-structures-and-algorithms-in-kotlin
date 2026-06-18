package problems

fun separateDigits(nums: IntArray): IntArray {
  val separatedDigits = mutableListOf<Int>()

  for (number in nums) {
    val numberAsString = number.toString()

    for (digitCharacter in numberAsString) {
      separatedDigits.add(digitCharacter - '0')
    }
  }

  return separatedDigits.toIntArray()
}
