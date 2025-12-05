package problems

fun countCollisions(directions: String): Int {
    val s = directions
    val n = s.length
    
    var left = 0
    // Skip all 'L's on the left (they will move left indefinitely without collisions)
    while (left < n && s[left] == 'L') left++
    
    var right = n - 1
    // Skip all 'R's on the right (they will move right indefinitely without collisions)
    while (right >= 0 && s[right] == 'R') right--
    
    // Count all non-'S' characters between left and right (inclusive)
    // These will either be 'L's that will be hit from the right or 'R's that will be hit from the left
    var stopped = 0
    for (i in left..right) {
        if (s[i] != 'S') {
            stopped++
        }
    }
    
    return stopped
}
