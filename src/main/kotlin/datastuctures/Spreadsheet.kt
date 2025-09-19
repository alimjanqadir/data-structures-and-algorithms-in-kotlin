package datastuctures

class Spreadsheet(private val rows: Int) {

  // 26 columns, rows rows; all initialized to 0
  private val values: IntArray = IntArray(rows * 26)

  fun setCell(cell: String, value: Int) {
    values[indexFromCell(cell)] = value
  }

  fun resetCell(cell: String) {
    values[indexFromCell(cell)] = 0
  }

  fun getValue(formula: String): Int {
    // formula is always of the form "=X+Y"
    val expression = formula.substring(1) // drop leading '='
    val plusPosition = expression.indexOf('+')
    val leftToken = expression.substring(0, plusPosition)
    val rightToken = expression.substring(plusPosition + 1)
    return parseOperand(leftToken) + parseOperand(rightToken)
  }

  // --- Helpers ---

  private fun parseOperand(token: String): Int {
    // If it starts with a digit, it's a number; otherwise, it's a cell like "A1"
    return if (token.isNotEmpty() && token[0].isDigit()) {
      token.toInt()
    } else {
      values[indexFromCell(token)]
    }
  }

  private fun indexFromCell(cell: String): Int {
    // cell like "A1", "B10", etc.
    val columnChar = cell[0]
    val columnIndex = columnChar - 'A' // 0..25
    val rowIndex = cell.substring(1).toInt() - 1 // 0-based
    // Flattened index (row-major)
    return rowIndex * 26 + columnIndex
  }
}
