package problems

import java.util.PriorityQueue

/** Returns the minimum arrival time at (n‑1,m‑1) with alternating step costs. */
fun minTimeToReachWithParity(moveTime: Array<IntArray>): Int {
    val rowCount = moveTime.size
    val columnCount = moveTime[0].size
    val infinity   = Long.MAX_VALUE / 4          // keep a wide safety margin

    /* distance[parity][row][col] = earliest time we reach this state */
    val distance = Array(2) {
        Array(rowCount) { LongArray(columnCount) { infinity } }
    }

    data class State(val time: Long,
                     val parity: Int,   // 0 → next step costs 1 s; 1 → next step costs 2 s
                     val row: Int,
                     val col: Int)

    val queue = PriorityQueue<State>(compareBy { it.time })

    distance[0][0][0] = 0L               // start inside (0,0), 0 moves taken so far
    queue.add(State(0L, 0, 0, 0))

    val delta = intArrayOf(1, 0, -1, 0, 1)   // four-neighbour offsets

    while (queue.isNotEmpty()) {
        val (currentTime, parity, row, col) = queue.poll()

        if (currentTime != distance[parity][row][col]) continue  // stale entry

        if (row == rowCount - 1 && col == columnCount - 1) {
            /* reached the treasure room */
            return currentTime.toInt()        // problem guarantees the answer fits Int
        }

        val travelTime = if (parity == 0) 1L else 2L
        val nextParity = parity xor 1

        for (d in 0 until 4) {
            val nextRow = row + delta[d]
            val nextCol = col + delta[d + 1]

            if (nextRow !in 0 until rowCount || nextCol !in 0 until columnCount) continue

            val earliestDeparture = maxOf(currentTime, moveTime[nextRow][nextCol].toLong())
            val arrivalTime       = earliestDeparture + travelTime

            if (arrivalTime < distance[nextParity][nextRow][nextCol]) {
                distance[nextParity][nextRow][nextCol] = arrivalTime
                queue.add(State(arrivalTime, nextParity, nextRow, nextCol))
            }
        }
    }

    return -1        // unreachable under the given constraints
}
