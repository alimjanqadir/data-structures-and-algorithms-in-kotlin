package algorithms.sorting

import algorithms.Person
import algorithms.peopleList

fun main(args: Array<String>) {
    val sortedList = bubbleSort(unsortedList = peopleList)
    println(sortedList)
}

fun bubbleSort(unsortedList: List<Person>): List<Person> {
    val sortList: MutableList<Person> = unsortedList.toMutableList()

    // Compare the neiboring numbers and swap it's position if it's smaller
    for (i in 0 until sortList.size) {
        for (j in 0 until sortList.size - 1) {
            if (sortList[j].age > sortList[j + 1].age) {
                val smaller = sortList[j + 1]
                val bigger = sortList[j]

                // Swap the smaller number to position of bigger
                sortList[j] = smaller
                sortList[j + 1] = bigger
            }
        }
    }

    return sortList
}

