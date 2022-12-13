import kotlin.math.min

class Solutiones {

    lateinit var dp: Array<IntArray>
    lateinit var m: Array<IntArray>
    var n: Int = 0

    fun minFallingPathSum(matrix: Array<IntArray>): Int {
        n = matrix.size
        if (n == 1) return matrix[0][0]
        m = matrix

        dp = Array(n) { IntArray(n) { 0 } }
        for (i in 0 until n) {
            dp[n - 1][i] = m[n - 1][i]
        }
        updateDp(0)

        return dp[0].min()!!
    }


    fun updateDp(row: Int) {

        if (row == n - 1) return
        updateDp(row + 1)
        for (i in 1 until n - 1) {
            dp[row][i] = min(min(dp[row + 1][i], dp[row + 1][i + 1]), dp[row + 1][i - 1]);
            dp[row][i] += m[row][i]
        }
        dp[row][0] = min(dp[row + 1][0], dp[row + 1][1])
        dp[row][0] += m[row][0]

        dp[row][n - 1] = min(dp[row + 1][n - 1], dp[row + 1][n - 2])
        dp[row][n - 1] += m[row][n - 1]
    }
}

fun main() {

    val input = arrayOf(
        intArrayOf(2, 1, 3),
        intArrayOf(6, 5, 4),
        intArrayOf(7, 8, 9)
    )

    println(Solutiones().minFallingPathSum(input))
}