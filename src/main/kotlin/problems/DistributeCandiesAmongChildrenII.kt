package problems

fun distributeCandies(totalCandies: Int, limitPerChild: Int): Long {
  fun choosePlus2(arg: Long): Long =
    if (arg < 0) 0
    else (arg + 2) * (arg + 1) / 2   // (arg+2 choose 2)


  val n = totalCandies.toLong()
  val limit = limitPerChild.toLong()
  val step = limit + 1                 // convenience

  val unrestricted = choosePlus2(n)
  val oneOver      = choosePlus2(n - step)
  val twoOver      = choosePlus2(n - 2 * step)
  val threeOver    = choosePlus2(n - 3 * step)

  return unrestricted -
    3 * oneOver +
    3 * twoOver -
    threeOver
}
