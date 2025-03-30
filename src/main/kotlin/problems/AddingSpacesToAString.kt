package problems

fun addSpaces(inputString: String, spaceIndices: IntArray): String {
    val resultBuilder = StringBuilder()
    var currentSpaceIndex = 0
    val totalCharacters = inputString.length
    val totalSpaces = spaceIndices.size

    for (currentCharacterIndex in 0 until totalCharacters) {
        // Check if the current character needs a space before it
        if (currentSpaceIndex < totalSpaces && currentCharacterIndex == spaceIndices[currentSpaceIndex]) {
            resultBuilder.append(' ')
            currentSpaceIndex++
        }
        resultBuilder.append(inputString[currentCharacterIndex])
    }
    
    return resultBuilder.toString()
}

fun main() {
    val inputString = "Leetcode"
    val spaceIndices = intArrayOf(8, 13, 15)
    println(addSpaces(inputString, spaceIndices))
}   