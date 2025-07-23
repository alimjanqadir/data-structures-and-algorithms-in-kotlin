package problems

class ThreeSumBruteForce {
  fun threeSum(nums: IntArray): List<List<Int>> {
    val n = nums.size
    val result = mutableSetOf<List<Int>>()
    // Iterate over all possible triplets
    for (i in 0 until n) {
      for (j in i + 1 until n) {
        for (k in j + 1 until n) {
          if (nums[i] + nums[j] + nums[k] == 0) {
            // Sort the triplet to handle duplicates
            val triplet = listOf(nums[i], nums[j], nums[k]).sorted()
            result.add(triplet)
          }
        }
      }
    }
    return result.toList()
  }
}

class ThreeSumEfficient {
  fun threeSum(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    nums.sort() // Sort the array to use two-pointer technique
    val n = nums.size

    for (i in 0 until n - 2) {
      // Skip duplicate values for the first number
      if (i > 0 && nums[i] == nums[i - 1]) continue

      var left = i + 1
      var right = n - 1

      while (left < right) {
        val sum = nums[i] + nums[left] + nums[right]

        when {
          sum == 0 -> {
            result.add(listOf(nums[i], nums[left], nums[right]))
            left++
            right--
            // Skip duplicates for the second number
            while (left < right && nums[left] == nums[left - 1]) left++
            // Skip duplicates for the third number
            while (left < right && nums[right] == nums[right + 1]) right--
          }
          sum < 0 -> left++
          else -> right--
        }
      }
    }

    return result
  }
}

class ThreeSumFunctional {
  fun threeSum(nums: IntArray): List<List<Int>> {
    if (nums.size < 3) return emptyList()

    return nums.sorted().let { sorted ->
      (0..sorted.lastIndex - 2).asSequence()
        .filter { i -> i == 0 || sorted[i] != sorted[i - 1] }
        .flatMap { i -> findPairs(sorted, i) }
        .toList()
    }
  }

  private fun findPairs(nums: List<Int>, i: Int): Sequence<List<Int>> = sequence {
    var left = i + 1
    var right = nums.lastIndex
    val target = -nums[i]

    while (left < right) {
      val sum = nums[left] + nums[right]
      when {
        sum == target -> {
          yield(listOf(nums[i], nums[left], nums[right]))
          do { left++ } while (left < right && nums[left] == nums[left - 1])
          do { right-- } while (left < right && nums[right] == nums[right + 1])
        }
        sum < target -> left++
        else -> right--
      }
    }
  }
}


