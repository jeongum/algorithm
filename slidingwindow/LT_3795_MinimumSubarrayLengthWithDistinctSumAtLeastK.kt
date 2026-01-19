package slidingwindow

import slidingwindow.LT_3795_MinimumSubarrayLengthWithDistinctSumAtLeastK.Companion.minLength
import kotlin.math.min

/**
 * https://leetcode.com/problems/sqrtx/solutions/7493629/kotlin-sqrtx-binary-search-by-jeongum-7z58
 */

class LT_3795_MinimumSubarrayLengthWithDistinctSumAtLeastK {
    companion object {
        fun minLength(nums: IntArray, k: Int): Int {
            var l = 0
            var minLength = Int.MAX_VALUE
            var sum = 0
            val countMap = mutableMapOf<Int, Int>();

            for (r in nums.indices) {
                val rightNum = nums[r]
                val prev = countMap.getOrDefault(rightNum, 0)
                if (prev == 0) sum += rightNum
                countMap[rightNum] = countMap.getOrDefault(rightNum, 0) + 1

                while (sum >= k) {
                    minLength = min(r - l + 1, minLength)

                    val leftNum = nums[l]
                    countMap[leftNum] = countMap.getOrDefault(leftNum, 0) - 1
                    if (countMap[leftNum] == 0) {
                        sum -= leftNum
                    }

                    l++
                }
            }

            return if (minLength == Int.MAX_VALUE) -1 else minLength
        }
    }
}

fun main(args: Array<String>) {
    println(minLength(intArrayOf(2, 2, 3, 1), 4))
}
