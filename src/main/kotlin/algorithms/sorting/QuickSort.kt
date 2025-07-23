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
