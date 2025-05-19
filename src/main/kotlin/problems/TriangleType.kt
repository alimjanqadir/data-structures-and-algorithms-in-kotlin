package problems

/**
 * 2971. Find Polygon With the Largest Perimeter
 * 
 * Given an integer array nums, return the largest perimeter of a polygon with a non-zero area,
 * formed from three of these lengths. If it is impossible to form any polygon of a non-zero area, return 0.
 * 
 * A polygon has a non-zero area if the sum of the lengths of any two sides is greater than the length of the third side.
 * 
 * Example 1:
 * Input: nums = [2,1,2]
 * Output: "scalene"
 * 
 * Example 2:
 * Input: nums = [3,3,3]
 * Output: "equilateral"
 * 
 * Example 3:
 * Input: nums = [3,3,5,5]
 * Output: "isosceles"
 */
fun triangleType(nums: IntArray): String {
    nums.sort()
    val a = nums[0]
    val b = nums[1]
    val c = nums[2]
    if (a + b <= c) {
        return "none"
    } else if (a == c) {
        return "equilateral"
    } else if (a == b || b == c) {
        return "isosceles"
    } else {
        return "scalene"
    }
}
