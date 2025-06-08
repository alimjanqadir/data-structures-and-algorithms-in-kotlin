package problems

/**
 * Return the integers 1 … n in lexicographic order.
 *
 * Time   O(n)
 * Memory O(1)  (aside from the result list of size n)
 */
fun lexicalOrder(upperLimit: Int): List<Int> {
  val lexicographicalNumbers = IntArray(upperLimit)

  var currentNumber = 1
  for (indexInResult in 0 until upperLimit) {
    lexicographicalNumbers[indexInResult] = currentNumber

    // 1. Prefer the left-most child in the prefix tree.
    if (currentNumber * 10 <= upperLimit) {
      currentNumber *= 10
      continue
    }

    // 2. Otherwise climb up until a right sibling exists …
    while (currentNumber % 10 == 9 || currentNumber + 1 > upperLimit) {
      currentNumber /= 10
    }
    // … then step to that sibling.
    currentNumber += 1
  }

  return lexicographicalNumbers.asList()
}
