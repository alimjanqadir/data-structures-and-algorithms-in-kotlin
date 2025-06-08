fun minimumOperations(nums: IntArray): Int {
  val seen = mutableSetOf<Int>()
  var suffixStart = nums.size

  for (index in nums.indices.reversed()) {
    if (!seen.add(nums[index])) {
      break
    }
    suffixStart = index
  }

  val elementsToRemove = suffixStart
  return (elementsToRemove + 2) / 3 // ceil(elementsToRemove / 3)
}
