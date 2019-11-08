package algorithms.sorting

import algorithms.Person
import algorithms.peopleList

fun main(args: Array<String>) {
    val sortedList = quickSort(unsortedList = peopleList)
    print(sortedList)
}

fun quickSort(unsortedList: List<Person>): List<Person> {
    val sortList = unsortedList.toMutableList()

    val left = 0
    val right = sortList.lastIndex

    quickSort(left, right, sortList)

    return sortList
}

fun quickSort(left: Int, right: Int, unsortedList: MutableList<Person>) {
    // In this algorithm right index can not pass through left index
    if (left > right) return

    // Setup the indexes used for looping
    var i = left
    var j = right

    val baseNumber = unsortedList[left].age

    // Loop until base number position has found
    while (i != j) {
        // Loop until a number smaller than base number has found and decrease tail index
        while (unsortedList[j].age >= baseNumber && i < j) {
            j--
        }

        // Loop until a number bigger than base number has found and decrease tail index
        while (unsortedList[i].age <= baseNumber && i < j) {
            i++
        }

        // Swap position of the numbers after smaller and bigger number has found compare to base number
        if (i < j) {
            val temp = unsortedList[i]
            unsortedList[i] = unsortedList[j]
            unsortedList[j] = temp
        }
    }

    // Base number has found  swap the position of the base number
    val temp = unsortedList[left]
    unsortedList[left] = unsortedList[i]
    unsortedList[i] = temp

    // Recursively sort left and right part of the base number
    quickSort(left, i - 1, unsortedList)    // Left
    quickSort(i + 1, right, unsortedList)   // Right


}
