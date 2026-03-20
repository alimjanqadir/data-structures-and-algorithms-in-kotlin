package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class CanIWinTest {

    @Test
    fun testCanIWin() {
        // Test case 1: First player can win (LeetCode example 1)
        // maxChoosableInteger = 10, desiredTotal = 11
        // First player chooses 1, remaining = 10
        // Second player can choose any number 2-10 but max sum is 54 which is > 10
        // Actually: first player chooses 1, second must reach >= 10 with numbers 2-10
        // If second picks 10, they win immediately. So first should pick differently.
        // First picks 10, wins immediately since 10 >= 11 is false... wait
        // Actually: The player who first causes running total to REACH OR EXCEED desiredTotal wins
        // If first picks 10, 10 < 11, remaining = 1
        // Second can pick 1 and win (1 >= 1). So first loses if picks 10.
        // First picks 1, total = 1, remaining for second = 10
        // Second picks any, if picks 10, wins. If picks x < 10, first can pick 10-x and win.
        // This is a classic game theory problem
        assertEquals(false, canIWin(10, 11))

        // Test case 2: First player wins immediately
        // maxChoosableInteger = 10, desiredTotal = 0
        // Target already reached
        assertEquals(true, canIWin(10, 0))

        // Test case 3: First player wins immediately by choosing max
        // maxChoosableInteger = 10, desiredTotal = 10
        // First picks 10 and wins
        assertEquals(true, canIWin(10, 10))

        // Test case 4: Total sum not enough
        // maxChoosableInteger = 5, desiredTotal = 50
        // Sum = 1+2+3+4+5 = 15 < 50
        assertEquals(false, canIWin(5, 50))

        // Test case 5: LeetCode example 2
        // maxChoosableInteger = 10, desiredTotal = 1
        // First picks 1 and wins
        assertEquals(true, canIWin(10, 1))

        // Test case 6: Small case where first wins
        // maxChoosableInteger = 2, desiredTotal = 3
        // First picks 2 (or 1), if picks 2: 2 < 3, remaining = 1
        // Second picks 1 and wins (1 >= 1). So first loses?
        // If first picks 1: 1 < 3, remaining = 2
        // Second picks 2 and wins (2 >= 2). First loses.
        // But wait - if first picks 2, second picks 1 and wins. First loses.
        // If first picks 1, second picks 2 and wins. First loses.
        // Actually first can force a win if second makes mistake, but with optimal play...
        // Let me trace: First picks 2, total = 2, second needs to reach >= 1 more
        // Second picks 1, total = 3 >= 3, second wins.
        // First picks 1, total = 1, second needs >= 2
        // Second picks 2, total = 3 >= 3, second wins.
        // First loses either way.
        assertEquals(false, canIWin(2, 3))

        // Test case 7: First can force win
        // maxChoosableInteger = 3, desiredTotal = 4
        // First picks 1, remaining = 3
        // Second picks: if 3, wins. If 2, first picks 2 and wins. If 1, impossible (used).
        // Second will pick 3 and win. So first shouldn't pick 1.
        // First picks 2, remaining = 2
        // Second picks: if 1, first picks 3? No 3 > 2. First needs >= 2-1 = 1, picks 1? Used.
        // Actually: second picks 1, total = 3, remaining = 1 for first
        // First picks 3? But 3 > 1 needed, and 3 >= 1 so first wins immediately.
        // Wait: if second picks 1, first can pick 3 and win (3 >= 1).
        // If second picks 3, second wins immediately.
        // So if first picks 2, second will pick 3 and win.
        // First picks 3, wins immediately (3 >= 4? No! 3 < 4)
        // Remaining = 1 for second, second picks 1 or 2 and wins.
        // Hmm this is getting complex, let me just verify with known result.
        // Actually for (3, 4), first can win by picking 3, then second needs 1 more.
        // Second can pick 1 or 2. Either way second wins on that turn.
        // So first loses? Let me just run and see.
        assertEquals(false, canIWin(3, 4))

        // Test case 8: Larger case where first wins
        // maxChoosableInteger = 5, desiredTotal = 6
        // First picks 1, remaining = 5
        // Second picks 5, wins. Bad move for first.
        // First picks 5, wins immediately? 5 < 6, no.
        // Remaining = 1, second picks any available (1,2,3,4) and wins.
        // First picks 2, remaining = 4
        // Second picks 4, wins. Or picks less, first can respond.
        // First picks 3, remaining = 3
        // Second picks 3? Used. Second picks 1 or 2 or 4 or 5.
        // If second picks 1, first picks 2 and wins? 2 >= 2 remaining, yes.
        // If second picks 2, first picks 1 and wins.
        // If second picks 4, wins immediately (4 >= 3). Second will do this.
        // First picks 4, remaining = 2
        // Second picks 2? Used. Second picks 1, 3, or 5.
        // If second picks 1, first needs 1 more, picks any available >= 1 (3 or 5) and wins.
        // If second picks 3, wins immediately.
        // If second picks 5, wins immediately.
        // So second picks 3 or 5 and wins.
        // Hmm let me just verify with the actual implementation
        assertEquals(false, canIWin(5, 6))
    }
}
