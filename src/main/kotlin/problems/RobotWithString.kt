package problems

fun robotWithString(input: String): String {
    // Pre-compute the smallest character that appears at or after each index
    val length = input.length
    val minSuffix = CharArray(length)
    minSuffix[length - 1] = input[length - 1]
    for (index in length - 2 downTo 0) {
        minSuffix[index] = minOf(input[index], minSuffix[index + 1])
    }

    // Use an array as a stack and build the answer in `paper`
    val stack = CharArray(length)
    var topIndex = -1 // -1 means the stack is empty
    val paper = StringBuilder()

    for (index in 0 until length) {
        // Push the next character from the input to the stack
        topIndex += 1
        stack[topIndex] = input[index]

        // Determine the smallest future character (or '{' which is after 'z')
        val nextMinimum = if (index + 1 < length) minSuffix[index + 1] else '{'

        // Pop from the stack while it does not break the lexicographical order
        while (topIndex >= 0 && stack[topIndex] <= nextMinimum) {
            paper.append(stack[topIndex])
            topIndex -= 1
        }
    }

    // Empty any remaining characters in the stack
    while (topIndex >= 0) {
        paper.append(stack[topIndex])
        topIndex -= 1
    }

    return paper.toString()
}
