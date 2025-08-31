package problems

fun solveSudoku(board: Array<CharArray>) {
  val rowUsed = IntArray(9)  // bit d set => digit (d+1) already used in row
  val colUsed = IntArray(9)  // bit d set => digit (d+1) already used in column
  val boxUsed = IntArray(9)  // bit d set => digit (d+1) already used in 3x3 box
  val emptyCells = ArrayList<Int>() // encode cell as rowIndex * 9 + columnIndex
  val allDigitsMask = (1 shl 9) - 1 // 0b1_1111_1111

  fun boxIndex(rowIndex: Int, columnIndex: Int): Int =
    (rowIndex / 3) * 3 + columnIndex / 3

  fun setDigit(rowIndex: Int, columnIndex: Int, digit: Int) {
    val bit = 1 shl (digit - 1)
    rowUsed[rowIndex] = rowUsed[rowIndex] or bit
    colUsed[columnIndex] = colUsed[columnIndex] or bit
    boxUsed[boxIndex(rowIndex, columnIndex)] =
      boxUsed[boxIndex(rowIndex, columnIndex)] or bit
    board[rowIndex][columnIndex] = ('0'.code + digit).toChar()
  }

  fun unsetDigit(rowIndex: Int, columnIndex: Int, digit: Int) {
    val bit = 1 shl (digit - 1)
    rowUsed[rowIndex] = rowUsed[rowIndex] and bit.inv()
    colUsed[columnIndex] = colUsed[columnIndex] and bit.inv()
    boxUsed[boxIndex(rowIndex, columnIndex)] =
      boxUsed[boxIndex(rowIndex, columnIndex)] and bit.inv()
    board[rowIndex][columnIndex] = '.'
  }

  fun candidateMask(rowIndex: Int, columnIndex: Int): Int {
    val used = rowUsed[rowIndex] or colUsed[columnIndex] or boxUsed[boxIndex(rowIndex, columnIndex)]
    return allDigitsMask and used.inv()
  }

  // Initialize masks and list of empty cells
  var rowIndex = 0
  while (rowIndex < 9) {
    var columnIndex = 0
    while (columnIndex < 9) {
      val cell = board[rowIndex][columnIndex]
      if (cell == '.') {
        emptyCells.add(rowIndex * 9 + columnIndex)
      } else {
        val digit = cell.code - '0'.code
        val bit = 1 shl (digit - 1)
        rowUsed[rowIndex] = rowUsed[rowIndex] or bit
        colUsed[columnIndex] = colUsed[columnIndex] or bit
        boxUsed[boxIndex(rowIndex, columnIndex)] =
          boxUsed[boxIndex(rowIndex, columnIndex)] or bit
      }
      columnIndex += 1
    }
    rowIndex += 1
  }

  fun solveFrom(cellStartIndex: Int): Boolean {
    if (cellStartIndex == emptyCells.size) return true

    // Choose the most constrained cell among remaining
    var bestIndex = -1
    var bestMask = 0
    var bestCount = 10

    var scanIndex = cellStartIndex
    while (scanIndex < emptyCells.size) {
      val encoded = emptyCells[scanIndex]
      val r = encoded / 9
      val c = encoded % 9
      val mask = candidateMask(r, c)
      val count = Integer.bitCount(mask)
      if (count < bestCount) {
        bestCount = count
        bestMask = mask
        bestIndex = scanIndex
        if (count == 1) break
      }
      scanIndex += 1
    }

    // No candidates -> dead end
    if (bestIndex == -1 || bestMask == 0) return false

    // Place the chosen cell at position cellStartIndex (in-place swap)
    val temp = emptyCells[cellStartIndex]
    emptyCells[cellStartIndex] = emptyCells[bestIndex]
    emptyCells[bestIndex] = temp

    val encoded = emptyCells[cellStartIndex]
    val r = encoded / 9
    val c = encoded % 9

    var mask = bestMask
    while (mask != 0) {
      val lowestBit = mask and -mask
      val zeroBasedDigit = Integer.numberOfTrailingZeros(lowestBit)
      val digit = zeroBasedDigit + 1

      setDigit(r, c, digit)
      if (solveFrom(cellStartIndex + 1)) return true
      unsetDigit(r, c, digit)

      mask = mask xor lowestBit
    }
    // Backtrack: restore order (optional for correctness)
    emptyCells[bestIndex] = emptyCells[cellStartIndex]
    emptyCells[cellStartIndex] = temp
    return false
  }

  solveFrom(0)
}

