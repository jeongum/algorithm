package arraystringkt

import arraystringkt.LT_88_MergeSortedArray.Companion.merge
import java.io.BufferedReader

/**
 * https://leetcode.com/problems/merge-sorted-array/submissions/1884484243
 */
class LT_88_MergeSortedArray {
    companion object {
        fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
            // 0. Edge Case
            if (n == 0) return
            if (m == 0) {
                for (i in 0..<n) {
                    nums1[i] = nums2[i]
                }
                return
            }

            // 1. Variable
            var i = m - 1
            var j = n - 1
            var k = m + n - 1

            // 2. Main
            while (j >= 0) {
                nums1[k--] = if (i >= 0 && nums1[i] > nums2[j]) nums1[i--] else nums2[j--]
            }
        }
    }
}

fun main(args: Array<String>) = with(System.`in`.bufferedReader()){

    val nums1 = readLine().split(' ').map { it.toInt() }.toIntArray()
    val m = readLine().toInt()
    val nums2 = readLine().split(' ').map { it.toInt() }.toIntArray()
    val n = readLine().toInt()

    merge(nums1, m, nums2, n)
}
