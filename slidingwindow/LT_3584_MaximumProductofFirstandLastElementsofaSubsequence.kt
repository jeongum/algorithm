package slidingwindow

import slidingwindow.LT_3584_MaximumProductofFirstandLastElementsofaSubsequence.Companion.maximumProduct

/**
 * https://leetcode.com/problems/maximum-product-of-first-and-last-elements-of-a-subsequence/solutions/7506485/kotlin-maximum-product-of-first-and-last-g6ht
 */


class LT_3584_MaximumProductofFirstandLastElementsofaSubsequence {
    companion object {
        fun maximumProduct(nums: IntArray, m: Int): Long {
            var answer = Long.MIN_VALUE
            val n = nums.size
            if (n == 1) return nums[0].toLong() * nums[0].toLong()

            var maxVal = Long.MIN_VALUE
            var minVal = Long.MAX_VALUE

            for (i in n - m downTo 0) {
                maxVal = maxVal.coerceAtLeast(nums[i + m - 1].toLong())
                minVal = minVal.coerceAtMost(nums[i + m - 1].toLong())

                val curVal = (nums[i].toLong() * maxVal).coerceAtLeast(nums[i].toLong() * minVal)

                answer = answer.coerceAtLeast(curVal)
            }

            return answer
        }
    }
}

fun main(args: Array<String>) {
    println(
        maximumProduct(
            intArrayOf(1,3,-5,5,6,-4), 3
        )
    )
}
