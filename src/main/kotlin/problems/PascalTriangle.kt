package problems

fun generate(numRows: Int): List<List<Int>> {
  val triangle = mutableListOf<List<Int>>()
  for (rowIndex in 0 until numRows) {
    val row = MutableList(rowIndex + 1) { 1 }
    for (col in 1 until rowIndex) {
      row[col] = triangle[rowIndex - 1][col - 1] + triangle[rowIndex - 1][col]
    }
    triangle.add(row)
  }
  return triangle
}
