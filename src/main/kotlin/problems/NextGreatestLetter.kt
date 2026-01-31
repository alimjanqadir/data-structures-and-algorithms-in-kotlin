fun nextGreatestLetter(letters: CharArray, target: Char): Char {
    // Binary search - find the leftmost position where letters[i] > target
    var left = 0
    var right = letters.size - 1
    
    while (left <= right) {
        val mid = left + (right - left) / 2
        
        if (letters[mid] > target) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    
    // After loop, left is the insertion point
    // If left is within bounds → that's our answer
    // If left == letters.size → wrap around to first element
    return if (left < letters.size) {
        letters[left]
    } else {
        letters[0]
    }
}
