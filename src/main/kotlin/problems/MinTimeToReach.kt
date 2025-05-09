import java.util.PriorityQueue
private data class State(val timeToArrive: Int, val row: Int, val col: Int) : Comparable<State> {
    override fun compareTo(other: State): Int = this.timeToArrive.compareTo(other.timeToArrive)
}

private val directions = listOf(
    Pair(-1, 0), // Up
    Pair(1, 0),  // Down
    Pair(0, -1), // Left
    Pair(0, 1)   // Right
)

fun minTimeToReach(moveTime: Array<IntArray>): Int {
    val numRows = moveTime.size
    val numCols = moveTime[0].size

    val minTimesToArrive = Array(numRows) { IntArray(numCols) { Int.MAX_VALUE } }
    val priorityQueue = PriorityQueue<State>()

    minTimesToArrive[0][0] = 0
    priorityQueue.add(State(timeToArrive = 0, row = 0, col = 0))

    while (priorityQueue.isNotEmpty()) {
        val currentState = priorityQueue.poll()
        val timeArrivedAtCurrent = currentState.timeToArrive
        val currentRow = currentState.row
        val currentCol = currentState.col

        if (timeArrivedAtCurrent > minTimesToArrive[currentRow][currentCol]) {
            continue
        }

        if (currentRow == numRows - 1 && currentCol == numCols - 1) {
            return timeArrivedAtCurrent
        }

        for (direction in directions) {
            val nextRow = currentRow + direction.first
            val nextCol = currentCol + direction.second

            if (nextRow in 0 until numRows && nextCol in 0 until numCols) {
                val earliestPossibleDepartureTime = timeArrivedAtCurrent
                val earliestAllowedEntryToNext = moveTime[nextRow][nextCol]
                val actualDepartureTime = maxOf(earliestPossibleDepartureTime, earliestAllowedEntryToNext)
                val arrivalTimeAtNext = actualDepartureTime + 1

                if (arrivalTimeAtNext < minTimesToArrive[nextRow][nextCol]) {
                    minTimesToArrive[nextRow][nextCol] = arrivalTimeAtNext
                    priorityQueue.add(State(arrivalTimeAtNext, nextRow, nextCol))
                }
            }
        }
    }

    return -1
}
