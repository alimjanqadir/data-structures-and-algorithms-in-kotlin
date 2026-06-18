package problems

fun getCommon(nums1: IntArray, nums2: IntArray): Int {
  var firstIndex = 0
  var secondIndex = 0

  while (firstIndex < nums1.size && secondIndex < nums2.size) {
    val firstValue = nums1[firstIndex]
    val secondValue = nums2[secondIndex]

    if (firstValue == secondValue) {
      return firstValue
    }

    if (firstValue < secondValue) {
      firstIndex += 1
    } else {
      secondIndex += 1
    }
  }

  return -1
}
