package tree

import java.util.LinkedList

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/solutions/7506045/kotlin-binary-tree-level-order-traversal-22k3
 */


class LT_102_BinaryTreeLevelOrderTraversal {
    companion object {
        class TreeNode(var `val`: Int) {
            var left: TreeNode? = null
            var right: TreeNode? = null
        }

        fun levelOrder(root: TreeNode?): List<List<Int>> {
            val answer: MutableList<List<Int>> = mutableListOf()

            if (root == null) return emptyList()

            val queue: LinkedList<TreeNode> = LinkedList<TreeNode>()
            queue.add(root)

            while (queue.isNotEmpty()) {
                answer.add(queue.toList().map { it.`val` })

                for (i in 0 until queue.size) {
                    val node = queue.removeFirst()
                    node.left?.let { queue.add(it) }
                    node.right?.let { queue.add(it) }
                }
            }

            return answer
        }
    }

}

fun main(args: Array<String>) {
}
