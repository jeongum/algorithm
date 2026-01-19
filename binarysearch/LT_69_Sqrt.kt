package binarysearch

import binarysearch.LT_69_Sqrt.Companion.mySqrt

/**
 * https://leetcode.com/problems/sqrtx/solutions/7493629/kotlin-sqrtx-binary-search-by-jeongum-7z58
 */

class LT_69_Sqrt {
    companion object {
        fun mySqrt(x: Int): Int {
            if (x < 2) return x

            var i = 0
            var j = x
            while (i <= j) {
                val mid = i + (j - i) / 2
                if (x / mid == mid) return mid

                if (x / mid < mid) j = mid - 1
                else i = mid + 1
            }

            return j
        }
    }
}

fun main(args: Array<String>) {
    println(mySqrt(8))
}
