import LT_1091_ShortestPathInBinaryMatrix.Companion.shortestPathBinaryMatrix
import java.util.ArrayDeque

/**
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/
 */

class LT_1091_ShortestPathInBinaryMatrix {
    companion object {
        val di = listOf(-1, -1, -1, 0, 0, 1, 1, 1)
        val dj = listOf(-1, 0, 1, -1, 1, -1, 0, 1)

        fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
            var result = -1
            val n = grid.size

            if(grid[0][0] != 0) return result

            val visited = Array(n) { BooleanArray(n) { false } }
            val q = ArrayDeque<List<Int>>()
            visited[0][0] = true
            q.add(listOf(0, 0, 1))

            while (q.size > 0) {
                val cur = q.poll()
                if(cur[0] == n-1 && cur[1] == n-1) {
                    result = cur[2]
                    break
                }

                for(i in 0..7) {
                    val ni = cur[0] + di[i]
                    val nj = cur[1] + dj[i]

                    if(ni in 0 until n && nj in 0 until n) {
                        if(grid[ni][nj] == 0 && !visited[ni][nj]) {
                            q.add(listOf(ni, nj, cur[2] + 1))
                            visited[ni][nj] = true
                        }
                    }
                }
            }

            return result
        }
    }

}

fun main(args: Array<String>) {
    println(shortestPathBinaryMatrix(arrayOf(intArrayOf(1,0,0), intArrayOf(1,1,0), intArrayOf(1,1,0))))
}
