package problems

fun simplifyPath(path: String): String {
  val deque = ArrayDeque<String>()

  // Split and process in one pass
  path.split('/')
    .filter { it.isNotEmpty() }
    .forEach { part ->
      when (part) {
        "." -> Unit  // Current directory - no operation needed
        ".." -> if (deque.isNotEmpty()) deque.removeLast()  // Go up one level
        else -> deque.addLast(part)  // Valid directory name
      }
    }

  // Handle empty path case
  if (deque.isEmpty()) return "/"

  // Build result efficiently
  return buildString {
    append('/')
    append(deque.joinToString("/"))
  }
}

fun simplifyPathFunctional(path: String): String {
  // Process path parts as a sequence of operations
  val canonicalPath = path
    .splitToSequence('/')
    .filter { it.isNotEmpty() }
    .fold(emptyList<String>()) { acc, part ->
      when (part) {
        "." -> acc
        ".." -> if (acc.isNotEmpty()) acc.dropLast(1) else acc
        else -> acc + part
      }
    }

  // Convert result to canonical form
  return buildString {
    append('/')
    append(canonicalPath.joinToString("/"))
  }
}

// Extension function to demonstrate path component processing
fun List<String>.processPathComponent(component: String): List<String> =
  when (component) {
    "." -> this
    ".." -> if (isNotEmpty()) dropLast(1) else this
    else -> this + component
  }

fun main() {
  // Test cases with detailed output
  listOf(
    "/home/",
    "/home//foo/",
    "/home/user/Documents/../Pictures",
    "/../",
    "/.../a/../b/c/../d/./",
    "/a/./b/../../c/"
  ).forEach { test ->
    println("""
            |Input: $test
            |Output: ${simplifyPath(test)}
            |---
    """.trimMargin())
  }
}