package problems

fun divideString(original: String, groupSize: Int, fill: Char): Array<String> {
  val totalGroups = (original.length + groupSize - 1) / groupSize
  val groupedStrings = Array(totalGroups) { "" }

  var groupIndex = 0
  var startIndex = 0
  while (startIndex < original.length) {
    val endIndexExclusive = (startIndex + groupSize).coerceAtMost(original.length)
    var currentGroup = original.substring(startIndex, endIndexExclusive)

    if (currentGroup.length < groupSize) {
      currentGroup = currentGroup.padEnd(groupSize, fill)
    }

    groupedStrings[groupIndex++] = currentGroup
    startIndex += groupSize
  }

  return groupedStrings
}
