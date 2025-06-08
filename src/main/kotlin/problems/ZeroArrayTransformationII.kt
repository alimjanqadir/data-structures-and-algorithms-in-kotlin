package problems

fun minZeroArrayTransformation(numbers: IntArray, queries: Array<IntArray>): Int {
  val arraySize = numbers.size
  var totalDecrementAtIndex = 0
  val differenceArray = IntArray(arraySize + 1)
  var queryCount = 0

  // Local function to update difference array for a query
  fun updateDifferenceArray(leftBound: Int, rightBound: Int, decrementValue: Int) {
    differenceArray[leftBound] += decrementValue
    if (rightBound + 1 < arraySize) {
      differenceArray[rightBound + 1] -= decrementValue
    }
  }

  // Local function to process a query at current index
  fun processQuery(query: IntArray, currentIndex: Int): Boolean {
    val (leftBound, rightBound, decrementValue) = query
    updateDifferenceArray(leftBound, rightBound, decrementValue)
    if (currentIndex in leftBound..rightBound) {
      totalDecrementAtIndex += decrementValue
      return true
    }
    return false
  }


  for (currentIndex in numbers.indices) {
    val targetValue = numbers[currentIndex]
    totalDecrementAtIndex += differenceArray[currentIndex]

    while (totalDecrementAtIndex < targetValue && queryCount < queries.size) {
      processQuery(queries[queryCount], currentIndex)
      queryCount = queryCount + 1
    }

    if (totalDecrementAtIndex < targetValue) {
      return -1 // Impossible to zero the array
    }
  }
  return queryCount
}
