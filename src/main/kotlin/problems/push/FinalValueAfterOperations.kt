package problems.push

class Solution {
  fun finalValueAfterOperations(operations: Array<String>): Int {
    var currentValue = 0
    for (operation in operations) {
      currentValue += if (operation.indexOf('+') != -1) 1 else -1
    }
    return currentValue
  }
}
