package problems

fun minOperations(s: String): Int {
  var changesIfStartWithZero = 0
  var changesIfStartWithOne = 0

  for (index in s.indices) {
    val expectedForZeroStart =
      if (index % 2 == 0) '0' else '1'

    val expectedForOneStart =
      if (index % 2 == 0) '1' else '0'

    if (s[index] != expectedForZeroStart) {
      changesIfStartWithZero += 1
    }

    if (s[index] != expectedForOneStart) {
      changesIfStartWithOne += 1
    }
  }

  return minOf(changesIfStartWithZero, changesIfStartWithOne)
}
