package problems

/**
 * Partitions the given [numbers] array into the minimum number of subsequences
 * such that the difference between the maximum and minimum value in each
 * subsequence does not exceed [maxDifference].
 *
 * The input array is sorted in place. A greedy scan then counts how many
 * groups are needed by starting a new group whenever the current element
 * differs from the start of the group by more than [maxDifference].
 */
fun partitionArray(numbers: IntArray, maxDifference: Int): Int {
  if (numbers.isEmpty()) return 0

  numbers.sort()

  var groups = 1
  var groupStart = numbers[0]

  for (value in numbers) {
    if (value - groupStart > maxDifference) {
      groups++
      groupStart = value
    }
  }

  return groups
}

