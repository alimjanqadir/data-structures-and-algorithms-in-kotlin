package problems.peopleawareofsecret

class Solution {
  fun peopleAwareOfSecret(n: Int, delay: Int, forget: Int): Int {
    val mod = 1_000_000_007
    val learned = IntArray(n + 1)
    learned[1] = 1

    var activeSharers = 0L  // use Long to avoid intermediate negatives/overflow

    for (day in 2..n) {
      val startDay = day - delay
      if (startDay >= 1) {
        activeSharers = (activeSharers + learned[startDay]) % mod
      }

      val stopDay = day - forget
      if (stopDay >= 1) {
        activeSharers = (activeSharers - learned[stopDay]) % mod
        if (activeSharers < 0) activeSharers += mod
      }

      learned[day] = activeSharers.toInt()
    }

    // Sum those who still remember at day n: learned in (n - forget + 1) .. n
    var result = 0L
    val firstRememberDay = (n - forget + 1).coerceAtLeast(1)
    for (day in firstRememberDay..n) {
      result = (result + learned[day]) % mod
    }
    return result.toInt()
  }
}
