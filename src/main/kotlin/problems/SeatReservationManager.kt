package problems
import java.util.*

class SeatManagerBruteForce(n: Int) {
    private val unreservedSeats = MutableList(n) { it + 1 }

    fun reserve(): Int {
        val seatNumber = unreservedSeats.minOrNull() ?: throw Exception("No seats available")
        unreservedSeats.remove(seatNumber)
        return seatNumber
    }

    fun unreserve(seatNumber: Int) {
        if (!unreservedSeats.contains(seatNumber)) {
            unreservedSeats.add(seatNumber)
        }
    }
}

class SeatManager(n: Int) {
    private val minHeap = PriorityQueue<Int>()

    init {
        for (i in 1..n) {
            minHeap.add(i)
        }
    }

    fun reserve(): Int {
        return minHeap.poll()
    }

    fun unreserve(seatNumber: Int) {
        minHeap.add(seatNumber)
    }
}

class SeatManagerFunctional(n: Int) {
    private val unreservedSeats = TreeSet<Int>()

    init {
        unreservedSeats.addAll(1..n)
    }

    fun reserve(): Int {
        val seatNumber = unreservedSeats.first()
        unreservedSeats.remove(seatNumber)
        return seatNumber
    }

    fun unreserve(seatNumber: Int) {
        unreservedSeats.add(seatNumber)
    }
}

fun main() {
    testBruteForce()
    testEfficient()
    testFunctional()
    println("All tests passed.")
}

fun testBruteForce() {
    val manager = SeatManagerBruteForce(5)
    assert(manager.reserve() == 1)
    assert(manager.reserve() == 2)
    manager.unreserve(1)
    assert(manager.reserve() == 1)
}

fun testEfficient() {
    val manager = SeatManager(5)
    assert(manager.reserve() == 1)
    assert(manager.reserve() == 2)
    manager.unreserve(1)
    assert(manager.reserve() == 1)
}

fun testFunctional() {
    val manager = SeatManagerFunctional(5)
    assert(manager.reserve() == 1)
    assert(manager.reserve() == 2)
    manager.unreserve(1)
    assert(manager.reserve() == 1)
}