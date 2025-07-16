package twentyfive.july.eighth

fun main() {
    val survey = arrayOf("TR", "RT", "TR")
    val choices = intArrayOf(7, 1, 3)
    val scoreMap = mutableMapOf<String, Int>()

    fun getScore(choice: Int): Int = when (choice) {
        1, 7 -> 3
        2, 6 -> 2
        3, 5 -> 1
        else -> 0
    }

    for (i in survey.indices) {
        val (a, b) = survey[i].map { it.toString() }
        val choice = choices[i]

        if (choice < 4) {
            scoreMap[a] = scoreMap.getOrDefault(a, 0) + getScore(choice)
        } else if (choice > 4) {
            scoreMap[b] = scoreMap.getOrDefault(b, 0) + getScore(choice)
        }
        // choice == 4는 skip
    }

    val result = buildString {
        listOf("RT", "CF", "JM", "AN").forEach {
            val (a, b) = it.map { c -> c.toString() }
            val aScore = scoreMap.getOrDefault(a, 0)
            val bScore = scoreMap.getOrDefault(b, 0)
            append(
                when {
                    aScore > bScore -> a
                    aScore < bScore -> b
                    else -> minOf(a, b)
                }
            )
        }
    }

    println(result)
}