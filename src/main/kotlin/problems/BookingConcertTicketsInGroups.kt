package problems

import kotlin.math.max
import kotlin.math.min

/**
 * A class representing the booking system for a concert venue.
 *
 * @property n The number of rows in the venue.
 * @property m The number of seats in each row.
 */
class BookMyShow(private val n: Int, private val m: Int) {
  // Array representing the number of available seats in each row.
  private val rows = IntArray(n) { m }
  // Segment tree to support efficient range queries and updates.
  private val segmentTree = SegmentTree(n, m.toLong())

  /**
   * Attempts to book `k` consecutive seats in a single row up to `maxRow`.
   *
   * @param k The number of consecutive seats to book.
   * @param maxRow The maximum row index to consider.
   * @return An array containing the row number and starting seat number, or an empty array if not possible.
   */
  fun gather(k: Int, maxRow: Int): IntArray {
    val row = segmentTree.findFirstGreaterOrEqual(k.toLong(), 0, maxRow)
    if (row == -1) return intArrayOf()

    val seat = m - rows[row]
    rows[row] -= k
    segmentTree.update(row, rows[row].toLong())
    return intArrayOf(row, seat)
  }

  /**
   * Attempts to book `k` seats across rows up to `maxRow`.
   *
   * @param k The total number of seats to book.
   * @param maxRow The maximum row index to consider.
   * @return True if booking is successful, false otherwise.
   */
  fun scatter(k: Int, maxRow: Int): Boolean {
    if (segmentTree.sumQuery(0, maxRow) < k.toLong()) return false

    segmentTree.scatterSeats(0, maxRow, k.toLong())
    return true
  }

  /**
   * Inner class representing the segment tree.
   * It can access the outer class's `rows` array.
   */
  private inner class SegmentTree(private val n: Int, initialValue: Long) {
    // Arrays to store the maximum available seats and total available seats in each node.
    val tree: LongArray = LongArray(4 * n)
    val sum: LongArray = LongArray(4 * n)

    init {
      build(0, 0, n - 1, initialValue)
    }

    /**
     * Builds the segment tree by initializing the nodes.
     */
    private fun build(node: Int, start: Int, end: Int, value: Long) {
      if (start == end) {
        tree[node] = value
        sum[node] = value
        return
      }
      val mid = (start + end) / 2
      build(2 * node + 1, start, mid, value)
      build(2 * node + 2, mid + 1, end, value)
      tree[node] = max(tree[2 * node + 1], tree[2 * node + 2])
      sum[node] = sum[2 * node + 1] + sum[2 * node + 2]
    }

    /**
     * Updates the value of a single element in the segment tree.
     */
    fun update(index: Int, value: Long) {
      update(0, 0, n - 1, index, value)
    }

    private fun update(node: Int, start: Int, end: Int, index: Int, value: Long) {
      if (start == end) {
        tree[node] = value
        sum[node] = value
        return
      }
      val mid = (start + end) / 2
      if (index <= mid) {
        update(2 * node + 1, start, mid, index, value)
      } else {
        update(2 * node + 2, mid + 1, end, index, value)
      }
      tree[node] = max(tree[2 * node + 1], tree[2 * node + 2])
      sum[node] = sum[2 * node + 1] + sum[2 * node + 2]
    }

    /**
     * Finds the first row within [left, right] that has at least `k` available seats.
     */
    fun findFirstGreaterOrEqual(k: Long, left: Int, right: Int): Int {
      return findFirstGreaterOrEqual(0, 0, n - 1, k, left, right)
    }

    private fun findFirstGreaterOrEqual(node: Int, start: Int, end: Int, k: Long, left: Int, right: Int): Int {
      if (left > end || right < start || tree[node] < k) return -1
      if (start == end) return start
      val mid = (start + end) / 2
      val leftResult = findFirstGreaterOrEqual(2 * node + 1, start, mid, k, left, right)
      return if (leftResult != -1) leftResult else findFirstGreaterOrEqual(2 * node + 2, mid + 1, end, k, left, right)
    }

    /**
     * Queries the total available seats within [left, right].
     */
    fun sumQuery(left: Int, right: Int): Long {
      return sumQuery(0, 0, n - 1, left, right)
    }

    private fun sumQuery(node: Int, start: Int, end: Int, left: Int, right: Int): Long {
      if (left > end || right < start) return 0
      if (left <= start && end <= right) return sum[node]
      val mid = (start + end) / 2
      return sumQuery(2 * node + 1, start, mid, left, right) + sumQuery(2 * node + 2, mid + 1, end, left, right)
    }

    /**
     * Recursively books `k` seats across rows [left, right].
     */
    fun scatterSeats(left: Int, right: Int, k: Long): Long {
      return scatterSeats(0, 0, n - 1, left, right, k)
    }

    private fun scatterSeats(node: Int, start: Int, end: Int, left: Int, right: Int, k: Long): Long {
      if (left > end || right < start || sum[node] == 0L || k == 0L) return 0L
      if (start == end) {
        val seatsToBook = min(sum[node], k)
        rows[start] -= seatsToBook.toInt()
        sum[node] -= seatsToBook
        tree[node] = sum[node]
        return seatsToBook
      }
      val mid = (start + end) / 2
      val bookedLeft = scatterSeats(2 * node + 1, start, mid, left, right, k)
      val bookedRight = scatterSeats(2 * node + 2, mid + 1, end, left, right, k - bookedLeft)
      sum[node] = sum[2 * node + 1] + sum[2 * node + 2]
      tree[node] = max(tree[2 * node + 1], tree[2 * node + 2])
      return bookedLeft + bookedRight
    }
  }
}

