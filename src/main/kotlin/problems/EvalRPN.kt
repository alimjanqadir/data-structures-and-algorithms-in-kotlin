package problems

import java.util.*

/**
 * Solution for evaluating Reverse Polish Notation expressions.
 * Time Complexity: O(n) where n is the length of input array
 * Space Complexity: O(n) for stack storage in worst case
 */
// Naive approach using imperative style with stack
fun evalRPNImperative(tokens: Array<String>): Int {
  val stack = ArrayDeque<Int>()

  for (token in tokens) {
    when (token) {
      "+", "-", "*", "/" -> {
        val b = stack.removeLast()
        val a = stack.removeLast()
        stack.addLast(
          when (token) {
            "+" -> a + b
            "-" -> a - b
            "*" -> a * b
            else -> a / b  // "/" case, truncates toward zero by default in Kotlin
          }
        )
      }

      else -> stack.addLast(token.toInt())
    }
  }

  return stack.last()
}

// Functional approach using fold and sealed class for operators
sealed class Token {
  data class Number(val value: Int) : Token()
  sealed class Operator : Token() {
    abstract fun apply(a: Int, b: Int): Int

    object Add : Operator() {
      override fun apply(a: Int, b: Int) = a + b
    }

    object Subtract : Operator() {
      override fun apply(a: Int, b: Int) = a - b
    }

    object Multiply : Operator() {
      override fun apply(a: Int, b: Int) = a * b
    }

    object Divide : Operator() {
      override fun apply(a: Int, b: Int) = a / b
    }
  }
}

private fun String.toToken(): Token = when (this) {
  "+" -> Token.Operator.Add
  "-" -> Token.Operator.Subtract
  "*" -> Token.Operator.Multiply
  "/" -> Token.Operator.Divide
  else -> Token.Number(toInt())
}

fun evalRPNFunctional(tokens: Array<String>): Int {
  return tokens
    .map { it.toToken() }
    .fold(emptyList<Int>()) { stack, token ->
      when (token) {
        is Token.Number -> stack + token.value
        is Token.Operator -> {
          val (rest, b, a) = stack.takeLast(2).let {
            Triple(stack.dropLast(2), it[1], it[0])
          }
          rest + token.apply(a, b)
        }
      }
    }
    .last()
}

// Extension function approach using sequence for potential memory optimization
fun evalRPNExtensions(tokens: Array<String>): Int {
  fun String.isOperator() = this in setOf("+", "-", "*", "/")

  fun List<Int>.applyOperator(operator: String): List<Int> {
    val (a, b) = takeLast(2)
    return dropLast(2) + when (operator) {
      "+" -> a + b
      "-" -> a - b
      "*" -> a * b
      else -> a / b
    }
  }

  return tokens.fold(emptyList<Int>()) { acc, token ->
    if (token.isOperator()) acc.applyOperator(token)
    else acc + token.toInt()
  }.single()
}

fun main() {

  // Test cases
  val testCases = listOf(
    arrayOf("2", "1", "+", "3", "*"),
    arrayOf("4", "13", "5", "/", "+"),
    arrayOf("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+")
  )

  println("Testing different implementations:")
  testCases.forEachIndexed { index, tokens ->
    println("\nTest case ${index + 1}: ${tokens.joinToString()}")
    println("Imperative result: ${evalRPNImperative(tokens)}")
    println("Functional result: ${evalRPNFunctional(tokens)}")
    println("Extensions result: ${evalRPNExtensions(tokens)}")
  }
}