package datastuctures

import algorithms.numberList

fun main(args: Array<String>) {
    val queue = Queue(100, 0, numberList.size)
    numberList.forEachIndexed { index: Int, i: Int -> queue.array[index] = i }

    while (queue.head != queue.tail) {
        val head = queue.head
        val tail = queue.tail

        // Print element that will going to removed.
        print("${queue.array[head]} removed ")

        // Add to queue
        queue.array[tail + head] = queue.array[head]

        // Remove from queue
        queue.head++
    }
}

class Queue(size: Int, var head: Int, var tail: Int) {
    val array: Array<Int> = Array(size) { 0 }
}