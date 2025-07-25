package algorithms.sorting

import algorithms.numberList
import java.math.BigDecimal

private fun bubbleSort() {
  val sortedList: MutableList<Int> = numberList.toMutableList()
  // Sort the array
  for (i in 0 until sortedList.size) {
    for (j in 0 until sortedList.size - 1) {
      if (sortedList[j] > sortedList[j + 1]) {
        val temp = sortedList[j]
        sortedList[j] = sortedList[j + 1]
        sortedList[j + 1] = temp
      }
    }
  }

  // Print the result
  for (i in 0 until sortedList.size) {
    if (i != sortedList.size - 1 && sortedList[i] == sortedList[i + 1]) continue
    print(" ${sortedList[i]}")
  }
  print("\n")
}

private fun bucketSort() {
  val range = numberList.max() ?: Int.MAX_VALUE
  // Initialize the buckets
  val sortList: MutableList<Int> = emptyList<Int>().toMutableList()
  for (i in 0..range) {
    sortList.add(0)
  }

  // Bucket sort
  for (number in numberList) {
    sortList[number] = 1
  }

  // Print the sorted result
  for ((index, value) in sortList.withIndex()) {
    if (value == 1) print(" $index")
  }
  print("\n")
}


fun quickSort(unSortedList: MutableList<Int>, left: Int, right: Int) {
  // left index bigger than right index means partition is already sorted
  if (left > right) return

  var i: Int = left
  var j: Int = right
  val baseNumber = unSortedList[left]

  while (i != j) {
    while (unSortedList[j] >= baseNumber && i < j) {
      j--
    }

    while (unSortedList[i] <= baseNumber && i < j) {
      i++
    }

    if (i < j) {
      val temp = unSortedList[i]
      unSortedList[i] = unSortedList[j]
      unSortedList[j] = temp
    }
  }

  val temp = unSortedList[left]
  unSortedList[left] = unSortedList[i]
  unSortedList[i] = temp


  quickSort(unSortedList, left, i - 1)
  quickSort(unSortedList, i + 1, right)
}
