class Fancy {

    private val mod = 1_000_000_007L
    private val values = mutableListOf<Long>()

    private var multiplier = 1L
    private var increment = 0L

    fun append(value: Int) {
        val adjusted = ((value - increment + mod) % mod * modInverse(multiplier)) % mod
        values.add(adjusted)
    }

    fun addAll(incrementValue: Int) {
        increment = (increment + incrementValue) % mod
    }

    fun multAll(multiplierValue: Int) {
        multiplier = (multiplier * multiplierValue) % mod
        increment = (increment * multiplierValue) % mod
    }

    fun getIndex(index: Int): Int {
        if (index >= values.size) return -1

        val storedValue = values[index]
        val result = (storedValue * multiplier + increment) % mod

        return result.toInt()
    }

    private fun modInverse(number: Long): Long {
        return modPow(number, mod - 2)
    }

    private fun modPow(baseValue: Long, exponentValue: Long): Long {
        var base = baseValue
        var exponent = exponentValue
        var result = 1L

        while (exponent > 0) {
            if (exponent % 2 == 1L) {
                result = (result * base) % mod
            }
            base = (base * base) % mod
            exponent /= 2
        }

        return result
    }
}
/**
 * Your Fancy object will be instantiated and called as such:
 * var obj = Fancy()
 * obj.append(`val`)
 * obj.addAll(inc)
 * obj.multAll(m)
 * var param_4 = obj.getIndex(idx)
 */
