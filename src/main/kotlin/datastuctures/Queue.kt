package datastuctures

import algorithms.numberList

class Queue(size: Int, var head: Int, var tail: Int) {
  val array: Array<Int> = Array(size) { 0 }
}
