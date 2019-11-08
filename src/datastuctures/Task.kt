package datastuctures

fun main(args: Array<String>) {
    // Declare fields that'll going to be used in this program
    val cardOfPlayerOne = arrayOf(2, 4, 1, 2, 5, 6)
    val cardsOfPlayerTwo = arrayOf(3, 1, 3, 5, 6, 4)
    val table = Stack(10)

    // Initialize the players
    val playerOne = Queue(100, 0, cardOfPlayerOne.size)
    val playerTwo = Queue(100, 0, cardsOfPlayerTwo.size)
    cardOfPlayerOne.forEachIndexed { index, i -> playerOne.array[index] = i }
    cardsOfPlayerTwo.forEachIndexed { index, i -> playerTwo.array[index] = i }

    // A bucket that indexes occurrence of certain card
    val book = Array(10) { 0 }

    // Counts the round which two players are playing
    var round = 0

    // Play the game until one of them has no card to play.
    while (round <= 100 && playerOne.head < playerOne.tail && playerTwo.head < playerTwo.tail) {
        // PlayerOne's turn
        var playerCard = playerOne.array[playerOne.head]
        if (book[playerCard] == 0) { // If there is no similar card
            // Put it to the table
            table.array[table.top] = playerCard
            book[playerCard] = 1
            table.top++
            playerOne.head++
        } else {
            // Took the cards in between and put it to player's queue
            playerOne.array[playerOne.tail] = playerCard
            playerOne.tail++
            playerOne.head++
            do {
                playerOne.array[playerOne.tail] = table.array[--table.top]
                book[table.array[table.top]] = 0 // Index bucket should also be cleaned
                playerOne.tail++
            } while (table.array[table.top] != playerCard)
        }

        // End the game if player one already wins.
        if (playerOne.head == playerOne.tail) break

        // PlayerTwo's turn
        playerCard = playerTwo.array[playerTwo.head]
        if (book[playerCard] == 0) { // If there is no similar card
            // Put it to the table
            table.array[table.top] = playerCard
            book[playerCard] = 1
            table.top++
            playerTwo.head++
        } else {
            // Took the cards in between and put it to player's queue
            playerTwo.array[playerTwo.tail] = playerCard
            playerTwo.tail++
            playerTwo.head++
            do {
                playerTwo.array[playerTwo.tail] = table.array[--table.top]
                book[table.array[table.top]] = 0 // Index bucket should also be cleaned
                playerTwo.tail++
            } while (table.array[table.top] != playerCard)
        }

        round++
    }

    // Whether game ended with a tie
    if (round >= 100) {
        println("The game ended with a tie.")
        return
    }

    // Print who did win
    if (playerOne.head == playerOne.tail) {
        // Player 1 Win
        println("Player 1 Win! Played Round: $round")

        // Print cards of the loosing side
        print("Cards left  on the player 2's hand: ")
        for (i in playerTwo.head until playerTwo.tail) {
            print("${playerTwo.array[i]} ")
        }
        println()
    } else {
        // Player 2 Win
        println("Player 2 Win! Played Round: $round")

        // Print cards of the loosing side
        print("Cards left  on the player 1's hand: ")
        for (i in playerOne.head until playerOne.tail) {
            print("${playerOne.array[i]} ")
        }
        println()
    }

    // Print cards in the table
    print("Cards left  on the table: ")
    for (i in 0 until table.top) {
        print("${table.array[i]} ")
    }
    println()

}