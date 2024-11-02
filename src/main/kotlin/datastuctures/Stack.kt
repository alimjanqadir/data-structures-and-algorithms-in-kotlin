package datastuctures

fun main(args: Array<String>) {
  val palindrome = arrayOf('p', 'o', 'p', 'o', 'p', 'o', 'p', 'o', 'p')
  var top = 0
  val stack = arrayOfNulls<Char>(100)
  val length = palindrome.size
  val middle = length / 2

  // Two letters always considered as palindrome
  if (length < 3) {
    println("Palindrome")
    return
  }


  // Add to stack
  for (i in 0 until middle) {
    stack[i] = palindrome[i]
    top++
  }

  val next: Int = if (length % 2 == 0) {
    middle
  } else {
    middle + 1
  }

  // Check rest of the palindrome with saved letters in stack
  for (i in next until length) {
    if (palindrome[i] != stack[--top]) {
      break
    }
  }

  // Check whether or not a palindrome
  if (top == 0) {
    println("Palindrome")
  } else {
    println("Not palindrome")
  }
}

class Stack(size: Int) {
  var top: Int = 0
  val array = Array(size) { 0 }
}