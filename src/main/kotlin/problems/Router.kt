package problems

import java.util.ArrayDeque
import java.util.HashMap
import java.util.HashSet

private data class Packet(val source: Int, val destination: Int, val timestamp: Int)
private data class Key(val source: Int, val destination: Int, val timestamp: Int)

/** Per-destination index: append-only timestamp compression + Fenwick tree with safe resizing. */
private class DestinationIndex {
  private val timestamps = ArrayList<Int>() // strictly increasing per destination
  private val indexOfTs = HashMap<Int, Int>() // ts -> 1-based index

  // Fenwick (BIT) and point counts; arrays are 1-based (index 0 unused)
  private var bit = IntArray(2)
  private var counts = IntArray(2)

  /** +1 on add. Creates the index lazily and grows arrays as needed. */
  fun add(timestamp: Int) {
    val idx = ensureIndexForAdd(timestamp)
    pointUpdate(idx, +1)
  }

  /** -1 on remove. Timestamp is guaranteed to exist for a stored packet. */
  fun remove(timestamp: Int) {
    val idx = indexOfTs[timestamp] ?: return
    pointUpdate(idx, -1)
  }

  /** Count of packets with ts in (-inf, bound]. */
  fun prefix(bound: Int): Int {
    if (timestamps.isEmpty()) return 0
    if (bound < timestamps[0]) return 0
    val upto = upperBound(bound) // number of keys <= bound (0..timestamps.size)
    return fenwickQuery(upto)
  }

  // ---------- helpers ----------

  /** Ensure index exists for ADD path (timestamps are appended in non-decreasing order per dest). */
  private fun ensureIndexForAdd(timestamp: Int): Int {
    val existing = indexOfTs[timestamp]
    if (existing != null) return existing

    // Monotonic append (by problem: global timestamps non-decreasing → per dest also non-decreasing)
    if (timestamps.isEmpty() || timestamp >= timestamps.last()) {
      timestamps.add(timestamp)
      val idx = timestamps.size // 1-based
      indexOfTs[timestamp] = idx
      ensureCapacity(idx + 1) // keep headroom
      return idx
    } else {
      // Should never happen under the problem constraints; defensive fallback:
      var pos = timestamps.binarySearch(timestamp)
      if (pos < 0) pos = -pos - 1
      timestamps.add(pos, timestamp)
      indexOfTs.clear()
      for (i in timestamps.indices) indexOfTs[timestamps[i]] = i + 1
      ensureCapacity(timestamps.size + 1)
      return indexOfTs[timestamp]!!
    }
  }

  /** Grow arrays and rebuild BIT from point counts to maintain correct aggregates. */
  private fun ensureCapacity(minSize: Int) {
    if (bit.size >= minSize) return
    var newSize = bit.size
    while (newSize < minSize) newSize = newSize shl 1

    val oldCounts = counts
    counts = IntArray(newSize)
    // copy point counts (only indices [1, oldCounts.lastIndex] are valid)
    val maxOld = oldCounts.size - 1
    for (i in 1..maxOld) counts[i] = oldCounts[i]

    // rebuild BIT from point counts
    bit = IntArray(newSize)
    for (i in 1..maxOld) {
      var idx = i
      val delta = counts[i]
      if (delta == 0) continue
      while (idx < newSize) {
        bit[idx] += delta
        idx += idx and -idx
      }
    }
  }

  private fun pointUpdate(idx1: Int, delta: Int) {
    // update point counts
    counts[idx1] += delta
    // update fenwick
    var i = idx1
    val n = bit.size
    while (i < n) {
      bit[i] += delta
      i += i and -i
    }
  }

  private fun fenwickQuery(idxInclusive: Int): Int {
    var i = idxInclusive
    var sum = 0
    while (i > 0) {
      sum += bit[i]
      i -= i and -i
    }
    return sum
  }

  /** number of timestamps <= target (0..timestamps.size) */
  private fun upperBound(target: Int): Int {
    var lo = 0
    var hi = timestamps.size
    while (lo < hi) {
      val mid = (lo + hi) ushr 1
      if (timestamps[mid] <= target) lo = mid + 1 else hi = mid
    }
    return lo
  }
}

class Router(private val memoryLimit: Int) {

  private val fifo = ArrayDeque<Packet>() // FIFO of stored packets
  private val present = HashSet<Key>() // duplicate detection (among stored only)
  private val perDest = HashMap<Int, DestinationIndex>() // fast range counts per destination

  fun addPacket(source: Int, destination: Int, timestamp: Int): Boolean {
    val key = Key(source, destination, timestamp)
    if (!present.add(key)) return false

    // Evict oldest if full
    if (fifo.size == memoryLimit) {
      val old = fifo.removeFirst()
      present.remove(Key(old.source, old.destination, old.timestamp))
      perDest.getOrPut(old.destination) { DestinationIndex() }
        .remove(old.timestamp)
    }

    fifo.addLast(Packet(source, destination, timestamp))
    perDest.getOrPut(destination) { DestinationIndex() }
      .add(timestamp)

    return true
  }

  fun forwardPacket(): IntArray {
    if (fifo.isEmpty()) return intArrayOf()
    val p = fifo.removeFirst()
    present.remove(Key(p.source, p.destination, p.timestamp))
    perDest.getOrPut(p.destination) { DestinationIndex() }
      .remove(p.timestamp)
    return intArrayOf(p.source, p.destination, p.timestamp)
  }

  fun getCount(destination: Int, startTime: Int, endTime: Int): Int {
    val idx = perDest[destination] ?: return 0
    val upToEnd = idx.prefix(endTime)
    val beforeStart = idx.prefix(startTime - 1)
    return upToEnd - beforeStart
  }
}
