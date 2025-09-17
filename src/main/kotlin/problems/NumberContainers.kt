package problems

import java.util.HashMap
import java.util.PriorityQueue

class NumberContainers {
  private val indexToNumber = HashMap<Int, Int>()
  private val numberToMinHeap = HashMap<Int, PriorityQueue<Int>>()

  fun change(index: Int, number: Int) {
    indexToNumber[index] = number
    val heap = numberToMinHeap.getOrPut(number) { PriorityQueue() }
    heap.add(index)
  }

  fun find(number: Int): Int {
    val heap = numberToMinHeap[number] ?: return -1

    while (heap.isNotEmpty()) {
      val smallestIndex = heap.peek()
      val current = indexToNumber[smallestIndex]
      if (current == number) {
        return smallestIndex
      } else {
        heap.poll()
      }
    }
    return -1
  }
}
