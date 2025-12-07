package problems

fun countOdds(low: Int, high: Int): Int {
    // 推荐写法：一行搞定
    return (high + 1) / 2 - low / 2
    
    // 另一种清晰的写法（如果你更喜欢显式判断）
//        var cnt = (high - low) / 2
//        if (low % 2 == 1) cnt++
//        if (high % 2 == 1) cnt++
//        return cnt
}
