package problems

class MinStack {
  private val stack = ArrayDeque<Int>()      // Main stack
  private val minStack = ArrayDeque<Int>()   // Auxiliary stack for minimums

  fun push(value: Int) {
    stack.addLast(value)
    // Update minimum stack
    if (minStack.isEmpty() || value <= minStack.last()) {
      minStack.addLast(value)
    } else {
      minStack.addLast(minStack.last())
    }
  }

  fun pop() {
    if (stack.isNotEmpty()) {
      stack.removeLast()
      minStack.removeLast()
    }
  }

  fun top(): Int {
    return stack.last()
  }

  fun getMin(): Int {
    return minStack.last()
  }
}

