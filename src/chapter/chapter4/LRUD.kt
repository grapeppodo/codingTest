package chapter.chapter4

fun main() {
    val moves = mutableListOf<String>()
    moves.add("R")
    moves.add("R")
    moves.add("R")
    moves.add("U")
    moves.add("D")
    moves.add("D")

    var x = 1
    var y = 1

    for (move in moves) {
        if (move == "L") {
            if (y > 1) {
                y -= 1
            }
        } else if (move == "R") {
            if (y < 5) {
                y += 1
            }
        } else if (move == "U") {
            if (x > 1) {
                x -= 1
            }
        } else { // D
            if (x < 5) {
                x += 1
            }
        }
    }

}