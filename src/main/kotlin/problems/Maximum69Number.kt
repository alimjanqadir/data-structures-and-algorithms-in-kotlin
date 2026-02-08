package problems.maximum69number

class Solution {
  fun maximum69Number(num: Int): Int {
    val digits = num.toString().toCharArray()
    for (position in digits.indices) {
      if (digits[position] == '6') {
        digits[position] = '9'
        return String(digits).toInt()
      }
    }
    return num
  }
}
