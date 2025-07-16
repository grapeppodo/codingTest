package twentyfive.july.eighth

fun main() {
    val survey = arrayOf("TR", "RT", "TR")
    val choices = intArrayOf(7, 1, 3)
    val scoreMap = mutableMapOf<String, Int>()

    // 1. 문항별 점수 기록
    for (i in survey.indices) {
        val choice = choices[i]

        val typeA = survey[i].substring(0, 1)
        val typeB = survey[i].substring(1, 2)

        if (choice in 1..3) {
            val score = when (choice) {
                1 -> {
                    3
                }

                2 -> {
                    2
                }

                else -> {
                    1
                }
            }
            if (scoreMap.containsKey(typeA)) {
                scoreMap[typeA] = scoreMap[typeA]!! + score
            } else {
                scoreMap.put(typeA, score)
            }
        } else if (choice in 5..7) {
            val score = when (choice) {
                5 -> {
                    1
                }

                6 -> {
                    2
                }

                else -> {
                    3
                }
            }

            if (scoreMap.containsKey(typeB)) {
                scoreMap[typeB] = scoreMap[typeB]!! + score
            } else {
                scoreMap[typeB] = score
            }
        }
    }

    // 2. 기록된 점수 돌면서 MBTI 계산
    val contents = arrayOf("RT", "CF", "JM", "AN")
    var result = ""

    for (content in contents) {
        val typeA = content.substring(0, 1) // R
        val typeB = content.substring(1, 2)  // T

        if (scoreMap.containsKey(typeA)) {
            scoreMap[typeA]!!
        } else {
            scoreMap.put(typeA, 0)
        }

        if (scoreMap.containsKey(typeB)) {
            scoreMap[typeB]!!
        } else {
            scoreMap.put(typeB, 0)
        }

        val typeAScore = scoreMap[typeA]!!
        val typeBScore = scoreMap[typeB]!!


        if (typeAScore > typeBScore) {
            result += typeA
        } else if (typeAScore == typeBScore) {
            val sortedType = mutableListOf(typeA, typeB)
            result += sortedType[0]
        } else {
            result += typeB
        }


    }
    println(result)

}