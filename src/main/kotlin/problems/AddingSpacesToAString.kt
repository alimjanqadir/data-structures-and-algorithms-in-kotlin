package problems

fun addSpaces(inputString: String, spaceIndices: IntArray): String {
  val resultBuilder = StringBuilder()
  var spaceIndex = 0
    
  for (i in inputString.indices) {
    if (spaceIndex < spaceIndices.size && i == spaceIndices[spaceIndex]) {
      resultBuilder.append(' ')
      spaceIndex++
    }
    resultBuilder.append(inputString[i])
  }
    
  return resultBuilder.toString()
}

