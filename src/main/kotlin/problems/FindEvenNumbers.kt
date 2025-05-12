fun findEvenNumbers(digits: IntArray): IntArray {
    // Step 1: tally available digits
    val digitSupply = IntArray(10)
    for (digit in digits) {
        digitSupply[digit]++
    }

    val validNumbers = mutableListOf<Int>()

    // Step 2: iterate through every even three‑digit candidate
    for (candidate in 100..998 step 2) {
        val hundredsDigit = candidate / 100
        val tensDigit = (candidate / 10) % 10
        val unitsDigit = candidate % 10   // even by loop design

        // Step 3: compute local requirements
        val required = IntArray(10)
        required[hundredsDigit]++
        required[tensDigit]++
        required[unitsDigit]++


        // Step 4: verify availability
        var canForm = true
        for (digit in 0..9) {
            if (required[digit] > digitSupply[digit]) {
                canForm = false
                break
            }
        }


        if (canForm) validNumbers.add(candidate)
    }


    // Kotlin list → IntArray for the expected return type
    return validNumbers.toIntArray()
}
