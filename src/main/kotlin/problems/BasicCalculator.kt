package problems

/**
 * Basic Calculator Implementation
 * Time Complexity: O(n) where n is the length of the string
 * Space Complexity: O(n) for the stack
 */
fun calculate(s: String): Int {
    val stack = ArrayDeque<Int>() // Stack to store intermediate results
    var result = 0 // Current result
    var sign = 1 // Current sign (1 for positive, -1 for negative)
    var i = 0 // Current position in string

    while (i < s.length) {
        when (s[i]) {
            ' ' -> i++ // Skip whitespace
            '+' -> {
                sign = 1
                i++
            }

            '-' -> {
                sign = -1
                i++
            }

            '(' -> {
                // Push current result and sign to stack
                stack.addLast(result)
                stack.addLast(sign)
                // Reset for new sub-expression
                result = 0
                sign = 1
                i++
            }

            ')' -> {
                // Evaluate sub-expression
                result = result * stack.removeLast() + stack.removeLast()
                i++
            }

            else -> {
                // Parse number
                var num = 0
                while (i < s.length && s[i].isDigit()) {
                    num = num * 10 + (s[i] - '0')
                    i++
                }
                result += sign * num
            }
        }
    }

    return result
}

/**
 * Functional implementation using recursive descent parser
 */
fun calculateFunctional(s: String): Int {
    data class ParseResult(val value: Int, val pos: Int)

    fun parseExpr(pos: Int): ParseResult {
        var currentPos = pos
        var result = 0
        var sign = 1

        fun skipWhitespace() {
            while (currentPos < s.length && s[currentPos] == ' ') currentPos++
        }

        while (currentPos < s.length) {
            skipWhitespace()
            when (val c = s[currentPos]) {
                '+' -> {
                    sign = 1
                    currentPos++
                }

                '-' -> {
                    sign = -1
                    currentPos++
                }

                '(' -> {
                    val subExpr = parseExpr(currentPos + 1)
                    result += sign * subExpr.value
                    currentPos = subExpr.pos + 1
                }

                ')' -> return ParseResult(result, currentPos)
                else -> if (c.isDigit()) {
                    var num = 0
                    while (currentPos < s.length && s[currentPos].isDigit()) {
                        num = num * 10 + (s[currentPos] - '0')
                        currentPos++
                    }
                    result += sign * num
                } else currentPos++
            }
        }

        return ParseResult(result, currentPos)
    }

    return parseExpr(0).value
}

/**
 * Test cases
 */
fun main() {
    val testCases = listOf(
        "1 + 1",
        " 2-1 + 2 ",
        "(1+(4+5+2)-3)+(6+8)",
        "-2 + 1",
        "((1))",
        "2147483647"
    )

    println("Testing iterative solution:")
    testCases.forEach { expression ->
        println("Expression: $expression")
        println("Result: ${calculate(expression)}")
        println()
    }

    println("Testing functional solution:")
    testCases.forEach { expression ->
        println("Expression: $expression")
        println("Result: ${calculateFunctional(expression)}")
        println()
    }
}