package problems

private class IntBag {
  var data = IntArray(DEFAULT_CAPACITY)
  var size = 0

  fun add(value: Int) {
    if (size == data.size) {
      data = data.copyOf(data.size * GROWTH_FACTOR)
    }
    data[size] = value
    size += 1
  }

  private companion object {
    const val DEFAULT_CAPACITY = 4
    const val GROWTH_FACTOR = 2
  }
}

fun minJumps(nums: IntArray): Int {
  val n = nums.size
  if (n == 1) return 0

  val maxValue = nums.maxOrNull() ?: 1
  val smallestPrimeFactor = buildSmallestPrimeFactor(maxValue)
  val primeToIndices = buildPrimeToIndices(nums, smallestPrimeFactor)
  val distance = IntArray(n) { -1 }
  val queue = IntArray(n)
  var front = 0
  var back = 0
  val expandedPrime = BooleanArray(maxValue + 1)

  distance[0] = 0
  queue[back] = 0
  back += 1

  while (front < back) {
    val currentIndex = queue[front]
    front += 1

    val currentDistance = distance[currentIndex]
    if (currentIndex == n - 1) return currentDistance

    back = enqueueIfUnvisited(currentIndex - 1, currentDistance, distance, queue, back)
    back = enqueueIfUnvisited(currentIndex + 1, currentDistance, distance, queue, back)
    back = expandPrimeTeleport(
      currentIndex,
      currentDistance,
      nums,
      smallestPrimeFactor,
      expandedPrime,
      primeToIndices,
      distance,
      queue,
      back
    )
  }

  return distance[n - 1]
}

private fun buildSmallestPrimeFactor(maxValue: Int): IntArray {
  val smallestPrimeFactor = IntArray(maxValue + 1) { it }
  val squareRootLimit = kotlin.math.sqrt(maxValue.toDouble()).toInt()

  for (candidate in 2..squareRootLimit) {
    if (smallestPrimeFactor[candidate] == candidate) {
      var multiple = candidate * candidate
      while (multiple <= maxValue) {
        if (smallestPrimeFactor[multiple] == multiple) {
          smallestPrimeFactor[multiple] = candidate
        }
        multiple += candidate
      }
    }
  }

  return smallestPrimeFactor
}

private fun buildPrimeToIndices(nums: IntArray, smallestPrimeFactor: IntArray): HashMap<Int, IntBag> {
  val primeToIndices = HashMap<Int, IntBag>()

  for (index in nums.indices) {
    var remainingValue = nums[index]
    while (remainingValue > 1) {
      val primeFactor = smallestPrimeFactor[remainingValue]
      val bag = primeToIndices.getOrPut(primeFactor) { IntBag() }
      bag.add(index)

      while (remainingValue % primeFactor == 0) {
        remainingValue /= primeFactor
      }
    }
  }

  return primeToIndices
}

private fun enqueueIfUnvisited(
  index: Int,
  currentDistance: Int,
  distance: IntArray,
  queue: IntArray,
  back: Int
): Int {
  if (index !in distance.indices || distance[index] != -1) {
    return back
  }

  distance[index] = currentDistance + 1
  queue[back] = index
  return back + 1
}

private fun expandPrimeTeleport(
  currentIndex: Int,
  currentDistance: Int,
  nums: IntArray,
  smallestPrimeFactor: IntArray,
  expandedPrime: BooleanArray,
  primeToIndices: HashMap<Int, IntBag>,
  distance: IntArray,
  queue: IntArray,
  back: Int
): Int {
  val currentValue = nums[currentIndex]
  if (currentValue <= 1 || smallestPrimeFactor[currentValue] != currentValue || expandedPrime[currentValue]) {
    return back
  }

  expandedPrime[currentValue] = true
  val targets = primeToIndices[currentValue] ?: return back
  var nextBack = back
  var position = 0

  while (position < targets.size) {
    val targetIndex = targets.data[position]
    if (distance[targetIndex] == -1) {
      distance[targetIndex] = currentDistance + 1
      queue[nextBack] = targetIndex
      nextBack += 1
    }
    position += 1
  }

  return nextBack
}
