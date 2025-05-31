package problems

fun snakesAndLadders(board: Array<IntArray>): Int {
    val size = board.size
    val lastSquare = size * size
    
    fun toCoordinates(square: Int): Pair<Int, Int> {
        val zeroBased = square - 1
        val rowFromBottom = zeroBased / size
        var column = zeroBased % size
        if (rowFromBottom % 2 == 1) {
            column = size - 1 - column          // reverse direction on odd rows
        }
        val matrixRow = size - 1 - rowFromBottom // convert bottom-based to top-based
        return matrixRow to column
    }


    val visited = BooleanArray(lastSquare + 1)
    val queue: ArrayDeque<Pair<Int, Int>> = ArrayDeque() // (square, rolls)
    queue.addLast(1 to 0)
    visited[1] = true

    while (queue.isNotEmpty()) {
        val (currentSquare, rollsSoFar) = queue.removeFirst()
        if (currentSquare == lastSquare) return rollsSoFar

        for (dieFace in 1..6) {
            var nextSquare = currentSquare + dieFace
            if (nextSquare > lastSquare) break

            val (row, col) = toCoordinates(nextSquare)
            if (board[row][col] != -1) {
                nextSquare = board[row][col]
            }


            if (!visited[nextSquare]) {
                visited[nextSquare] = true
                queue.addLast(nextSquare to rollsSoFar + 1)
            }
        }
    }
    return -1
}
