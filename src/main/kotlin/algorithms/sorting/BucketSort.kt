package algorithms.sorting

import algorithms.numberList

fun bucketSort(unsortedList: List<Int>): List<Int> {
  val sortList = mutableListOf<Int>()
  // Initialize the sort list
  val range = unsortedList.max() ?: Int.MAX_VALUE
  for (i in 0..range) {
    sortList.add(0)
  }

  // Put numbers into bucket
  for (i in unsortedList) {
    sortList[i]++
  }

  // Return the result
  val result: MutableList<Int> = mutableListOf()
  for (i in sortList.size - 1 downTo 0) {
    for (j in 1..sortList[i]) {
      result.add(i)
    }
  }

  return result
}
