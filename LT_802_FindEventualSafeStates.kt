import LT_802_FindEventualSafeStates.Companion.eventualSafeNodes

/**
 * https://leetcode.com/problems/find-eventual-safe-states/submissions/992654637/
 */

class LT_802_FindEventualSafeStates {
    companion object {
        fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
            val n = graph.size
            val result = mutableListOf<Int>()
            val visited = BooleanArray(n)
            val safe = BooleanArray(n)

            for(i in 0 until n) {
                if(dfs(i, visited, safe, graph)) {
                    result.add(i)
                }
            }

            return result
        }

        private fun dfs(node: Int, visited: BooleanArray, safe:BooleanArray, graph: Array<IntArray>): Boolean {
            if(visited[node]) return safe[node]

            visited[node] = true

            graph[node].forEach {i ->
                if(!dfs(i, visited, safe, graph)) {
                    return false
                }
            }

            safe[node] = true
            return true
        }
    }

}

fun main(args: Array<String>) {
    println(eventualSafeNodes(arrayOf(intArrayOf(1,2,3,4),intArrayOf(1,2),intArrayOf(3,4),intArrayOf(0,4),intArrayOf())))
}
