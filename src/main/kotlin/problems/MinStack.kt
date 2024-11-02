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

fun main() {
  val minStack = MinStack()

  // Test case 1: Basic operations
  minStack.push(-2)
  minStack.push(0)
  minStack.push(-3)
  println("Minimum after pushing -2,0,-3: ${minStack.getMin()}") // Expected: -3

  // Test case 2: Pop operation
  minStack.pop()
  println("Top after pop: ${minStack.top()}")       // Expected: 0
  println("Minimum after pop: ${minStack.getMin()}") // Expected: -2

  // Test case 3: Multiple elements with same minimum
  minStack.push(-2)
  println("Minimum after pushing another -2: ${minStack.getMin()}") // Expected: -2

  // Test case 4: Sequence of operations
  minStack.pop()
  minStack.pop()
  println("Minimum after two pops: ${minStack.getMin()}") // Expected: -2
}