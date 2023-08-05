package dp

import dp.LT_95_UniqueBinarySearchTrees2.Companion.generateTrees

/**
 * https://leetcode.com/problems/unique-binary-search-trees-ii/submissions/1012667659/
 */
class LT_95_UniqueBinarySearchTrees2 {
    companion object {
        class TreeNode(var `val`: Int) {
            var left: TreeNode? = null
            var right: TreeNode? = null
        }

        val memo: MutableMap<Pair<Int, Int>, MutableList<TreeNode?>> = mutableMapOf()
        fun treesStartToEnd(start: Int, end: Int): MutableList<TreeNode?> {
            val tn: MutableList<TreeNode?> = mutableListOf()
            if (start > end) {
                tn.add(null)
                return tn
            }
            if (start == end) {
                tn.add(TreeNode(start))
                return tn
            }
            if (memo.contains((start to end))) {
                return memo[(start to end)]!!
            }

            for (i in start..end) {
                val left = treesStartToEnd(start, i - 1)
                val right = treesStartToEnd(i + 1, end)
                left.forEach { l ->
                    right.forEach { r ->
                        tn.add(
                            TreeNode(i).also {
                                it.right = r
                                it.left = l
                            }
                        )
                    }
                }
            }
            memo[(start to end)] = tn
            return tn
        }

        fun generateTrees(n: Int): List<TreeNode?> {
            return treesStartToEnd(1, n)
        }
    }
}

fun main(args: Array<String>) {
    val solution = generateTrees(3)
    println(solution)
}
