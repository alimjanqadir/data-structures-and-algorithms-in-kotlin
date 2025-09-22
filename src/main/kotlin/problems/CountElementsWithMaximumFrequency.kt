package problems

fun maxFrequencyElements(nums: IntArray): Int {
  val valueFrequency = IntArray(101)

  for (value in nums) {
    valueFrequency[value] += 1
  }

  var maxFrequency = 0
  for (frequency in valueFrequency) {
    if (frequency > maxFrequency) {
      maxFrequency = frequency
    }
  }

  var totalWithMaxFrequency = 0
  for (frequency in valueFrequency) {
    if (frequency == maxFrequency) {
      totalWithMaxFrequency += frequency
    }
  }

  return totalWithMaxFrequency
}
