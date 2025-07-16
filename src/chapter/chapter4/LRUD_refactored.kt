package chapter.chapter4

fun main() {
    val n = 5
    val moves = listOf("R", "R", "R", "U", "D", "D")

    // L, R, U, D 순서
    val dx = listOf(0, 0, -1, 1)
    val dy = listOf(-1, 1, 0, 0)
    val directions = listOf("L", "R", "U", "D")

    var x = 1
    var y = 1

    for (move in moves) {
        val idx = directions.indexOf(move)
        if (idx == -1) continue // 잘못된 명령 무시

        val nx = x + dx[idx]
        val ny = y + dy[idx]

        if (nx in 1..n && ny in 1..n) {
            x = nx
            y = ny
        }
    }

    println("$x $y")
}