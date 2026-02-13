fun champagneTower(poured: Int, queryRow: Int, queryGlass: Int): Double {
  val champagne = Array(queryRow + 1) { rowIndex ->
    DoubleArray(rowIndex + 1)
  }

  champagne[0][0] = poured.toDouble()

  for (rowIndex in 0 until queryRow) {
    for (glassIndex in 0..rowIndex) {
      val overflow = (champagne[rowIndex][glassIndex] - 1.0)
        .coerceAtLeast(0.0)

      if (overflow > 0.0) {
        val sharedOverflow = overflow / 2.0
        champagne[rowIndex + 1][glassIndex] += sharedOverflow
        champagne[rowIndex + 1][glassIndex + 1] += sharedOverflow
      }
    }
  }

  return champagne[queryRow][queryGlass].coerceAtMost(1.0)
}
