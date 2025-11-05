package problems

fun findXSum(nums: IntArray, k: Int, x: Int): LongArray {
    val n = nums.size
    val resultLength = n - k + 1
    val answer = LongArray(resultLength)

    val freqMap = HashMap<Int, Int>()

    // comparator: higher freq first, if tie higher value first
    val rankComparator = Comparator<Pair<Int, Int>> { a, b ->
        if (a.first != b.first) b.first.compareTo(a.first) else b.second.compareTo(a.second)
    }

    val selected = java.util.TreeSet<Pair<Int, Int>>(rankComparator)
    val other = java.util.TreeSet<Pair<Int, Int>>(rankComparator)

    var sumSelected: Long = 0L

    fun removeOldPairFromSets(oldFreq: Int, value: Int) {
        if (oldFreq <= 0) return 
        val oldKey = Pair(oldFreq, value)
        if (selected.remove(oldKey)) {
            sumSelected -= oldFreq.toLong() * value.toLong()
        } else {
            other.remove(oldKey)
        }
    }

    fun insertNewPairToSets(newFreq: Int, value: Int) {
        if (newFreq <= 0) return 
        val newKey = Pair(newFreq, value)

        other.add(newKey)

        // If selected already full, we may want to swap the top of other with worst of selected
        if (selected.size >= x && selected.isNotEmpty()) {
            val bestInOther = other.first()
            val worstInSelected = selected.last()
            if (rankComparator.compare(bestInOther, worstInSelected) < 0) {
                // swap
                other.remove(bestInOther)
                selected.remove(worstInSelected)
                sumSelected -= worstInSelected.first.toLong() * worstInSelected.second.toLong()

                selected.add(bestInOther)
                sumSelected += bestInOther.first.toLong() * bestInOther.second.toLong()
                other.add(worstInSelected)
            }
        }
    }

    fun addValueToWindow(value: Int) {
        val oldFreq = freqMap.getOrDefault(value, 0)
        removeOldPairFromSets(oldFreq, value)

        val newFreq = oldFreq + 1
        freqMap[value] = newFreq
        insertNewPairToSets(newFreq, value)

        val distinctCount = freqMap.size
        val targetSelectedSize = minOf(x, distinctCount)
        while (selected.size < targetSelectedSize && other.isNotEmpty()) {
            val bestInOther = other.first()
            other.remove(bestInOther)
            selected.add(bestInOther)
            sumSelected += bestInOther.first.toLong() * bestInOther.second.toLong()
        }
    }

    fun removeValueFromWindow(value: Int) {
        val oldFreq = freqMap.getOrDefault(value, 0)
        if (oldFreq == 0) return 
        removeOldPairFromSets(oldFreq, value)

        val newFreq = oldFreq - 1
        if (newFreq == 0) {
            freqMap.remove(value)
        } else {
            freqMap[value] = newFreq
        }

        if (newFreq > 0) insertNewPairToSets(newFreq, value)

        val distinctCount = freqMap.size
        val targetSelectedSize = minOf(x, distinctCount)
        while (selected.size > targetSelectedSize) {
            val worstInSelected = selected.last()
            selected.remove(worstInSelected)
            sumSelected -= worstInSelected.first.toLong() * worstInSelected.second.toLong()
            other.add(worstInSelected)
        }

        // Ensure top elements are in selected by swapping while beneficial
        if (selected.isNotEmpty() && other.isNotEmpty()) {
            var changed = true
            while (changed && other.isNotEmpty() && selected.isNotEmpty()) {
                val bestInOther = other.first()
                val worstInSelected = selected.last()
                if (rankComparator.compare(bestInOther, worstInSelected) < 0) {
                    other.remove(bestInOther)
                    selected.remove(worstInSelected)

                    selected.add(bestInOther)
                    other.add(worstInSelected)

                    sumSelected += bestInOther.first.toLong() * bestInOther.second.toLong()
                    sumSelected -= worstInSelected.first.toLong() * worstInSelected.second.toLong()
                } else {
                    changed = false
                }
            }
        } else if (selected.size < targetSelectedSize && other.isNotEmpty()) {
            val bestInOther = other.first()
            other.remove(bestInOther)
            selected.add(bestInOther)
            sumSelected += bestInOther.first.toLong() * bestInOther.second.toLong()
        }
    }

    // initialize first window
    for (index in 0 until k) addValueToWindow(nums[index])
    answer[0] = sumSelected

    for (startIndex in 1 until resultLength) {
        val outgoing = nums[startIndex - 1]
        val incoming = nums[startIndex + k - 1]
        removeValueFromWindow(outgoing)
        addValueToWindow(incoming)
        answer[startIndex] = sumSelected
    }

    return answer
}
