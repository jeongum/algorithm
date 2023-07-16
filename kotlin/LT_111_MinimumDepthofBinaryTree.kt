package org.algorithm.kotlin

import java.util.ArrayDeque

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/submissions/990988119/
 */
class LT_111_MinimumDepthofBinaryTree {
    companion object {
        class TreeNode(var `val`: Int) {
            var left: TreeNode? = null
            var right: TreeNode? = null
        }

        fun minDepth(root: TreeNode?): Int {
            if(root == null) return 0

            val q = ArrayDeque<TreeNode>()
            q.add(root)

            var depth = 1

            while (q.isNotEmpty()) {
                val curSize = q.size

                repeat(curSize) {
                    val curNode = q.poll()
                    if (curNode.left == null && curNode.right == null) return depth

                    curNode.left?.let { q.add(it) }
                    curNode.right?.let { q.add(it) }
                }

                depth++
            }

            return depth
        }
    }

}

fun main(args: Array<String>) {
}
