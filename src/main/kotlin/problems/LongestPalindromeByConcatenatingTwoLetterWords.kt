package problems

/**
 * 2131. Longest Palindrome by Concatenating Two-Letter Words
 * 
 * Time Complexity: O(n) where n is the number of words
 * Space Complexity: O(1) - fixed 26×26 table
 */
fun longestPalindrome(words: Array<String>): Int {
  // 26×26 bucket: bucket[first][second] counts occurrences of "ab" where a='a'+first, b='a'+second
  val bucket = Array(26) { IntArray(26) }
  for (word in words) {
    val first = word[0] - 'a'
    val second = word[1] - 'a'
    bucket[first][second]++
  }

  var totalLength = 0                // length built so far
  var hasCenterCandidate = false     // whether an identical-letter word is left for the center

  // 1. Handle asymmetric pairs "ab" with "ba"
  for (a in 0 until 26) {
    for (b in a + 1 until 26) {    // only need each unordered pair once
      val pairs = minOf(bucket[a][b], bucket[b][a])
      totalLength += pairs * 4   // each pair contributes "ab..ba"
      bucket[a][b] -= pairs
      bucket[b][a] -= pairs
    }
  }


  // 2. Handle identical-letter buckets "aa", "bb", ...
  for (c in 0 until 26) {
    val count = bucket[c][c]
    // Even part goes to both ends
    totalLength += (count / 2) * 4
    // Odd leftover may become the center if not used yet
    if (count % 2 == 1) hasCenterCandidate = true
  }


  // 3. Optional center adds exactly two letters
  if (hasCenterCandidate) totalLength += 2
  return totalLength
}
