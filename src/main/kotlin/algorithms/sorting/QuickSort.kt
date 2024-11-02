fun main() {
  println(quickSort(arrayOf(9, 7, 5, 3, 10)).joinToString())
  println(quickSort(arrayOf(11, 7, 5, 3, -1)).joinToString())
  println(quickSort(arrayOf(11, 7, 0, 3, -1)).joinToString())
}

fun quickSort(collection: Array<Int>): Array<Int> {
  val mutableList = collection.copyOf().toMutableList()
  fun quickSortHelper(left: Int, right: Int) {
    fun swap(i: Int, pivot: Int) {
      val temp = mutableList[i]
      mutableList.removeAt(i)
      mutableList.add(pivot, temp)
    }

    if (left > right) return

    var pivot = right
    var i = left
    while (i < pivot) {
      if (mutableList[i] > mutableList[pivot]) {
        swap(i, pivot)
        pivot -= 1
      } else {
        i += 1
      }
    }

    quickSortHelper(left, pivot - 1)
    quickSortHelper(pivot + 1, right)
  }
  quickSortHelper(0, mutableList.size - 1)
  return mutableList.toTypedArray()
}
