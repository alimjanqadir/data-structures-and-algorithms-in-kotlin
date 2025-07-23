package problems

fun summaryRangesBruteForce(numbers: IntArray): List<String> {
  if (numbers.isEmpty()) return emptyList()

  val ranges = mutableListOf<String>()
  var rangeStart = numbers[0]
  var currentNumber = rangeStart

  for (i in 1..numbers.size) {
    if (i == numbers.size || numbers[i] != currentNumber + 1) {
      ranges.add(formatRange(rangeStart, currentNumber))
      if (i < numbers.size) {
        rangeStart = numbers[i]
        currentNumber = rangeStart
      }
    } else {
      currentNumber = numbers[i]
    }
  }

  return ranges
}

/**
 * Optimized approach using two pointers.
 * More efficient in terms of code clarity and maintainability.
 */
fun summaryRanges(numbers: IntArray): List<String> {
  if (numbers.isEmpty()) return emptyList()

  val ranges = mutableListOf<String>()
  var currentIndex = 0

  while (currentIndex < numbers.size) {
    val rangeStart = numbers[currentIndex]

    while (hasNextConsecutiveNumber(numbers, currentIndex)) {
      currentIndex++
    }

    val rangeEnd = numbers[currentIndex]
    ranges.add(formatRange(rangeStart, rangeEnd))

    currentIndex++
  }

  return ranges
}

/**
 * Functional approach using Kotlin's sequence operations.
 * More declarative and idiomatic Kotlin style.
 */
fun summaryRangesFunctional(numbers: IntArray): List<String> {
  return numbers.asSequence()
    .mapIndexed { index, number ->
      RangeElement(
        value = number,
        isStart = index == 0 || numbers[index - 1] + 1 != number,
        isEnd = index == numbers.lastIndex || numbers[index + 1] != number + 1
      )
    }
    .fold(mutableListOf<NumberRange>()) { ranges, element ->
      if (element.isStart) {
        ranges.add(NumberRange(element.value, element.value))
      }
      if (!element.isEnd) {
        ranges.last().end = element.value + 1
      }
      ranges
    }
    .map { it.format() }
    .toList()
}

// Helper classes for functional approach
private data class RangeElement(
  val value: Int,
  val isStart: Boolean,
  val isEnd: Boolean
)

private data class NumberRange(
  val start: Int,
  var end: Int
) {
  fun format(): String = if (start == end) "$start" else "$start->$end"
}

// Helper functions
private fun hasNextConsecutiveNumber(numbers: IntArray, currentIndex: Int): Boolean {
  val hasNextNumber = currentIndex + 1 < numbers.size
  return hasNextNumber && numbers[currentIndex + 1] == numbers[currentIndex] + 1
}

private fun formatRange(start: Int, end: Int): String {
  return if (start == end) "$start" else "$start->$end"
}

/**
 * Main function to demonstrate and test different implementations
 */
