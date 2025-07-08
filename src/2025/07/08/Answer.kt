package `2025`.`07`.`08`

// 내가 푼 버전 + 제출용
class Solution {
    fun solution(survey: Array<String>, choices: IntArray): String {
        var answer: String = ""
        val scoreList = mutableMapOf<String, Int>()

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
                if (scoreList.containsKey(typeA)) {
                    scoreList[typeA] = scoreList[typeA]!! + score
                } else {
                    scoreList.put(typeA, score)
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

                if (scoreList.containsKey(typeB)) {
                    scoreList[typeB] = scoreList[typeB]!! + score
                } else {
                    scoreList[typeB] = score
                }
            }
        }

        // 2. 기록된 점수 돌면서 MBTI 계산
        val contents = arrayOf("RT", "CF", "JM", "AN")

        for (content in contents) {

            val typeA = content.substring(0, 1)
            val typeB = content.substring(1, 2)


            if (scoreList.containsKey(typeA)) {
                scoreList[typeA]!!
            } else {
                scoreList.put(typeA, 0)
            }

            if (scoreList.containsKey(typeB)) {
                scoreList[typeB]!!
            } else {
                scoreList.put(typeB, 0)
            }

            val typeAScore = scoreList[typeA]!!
            val typeBScore = scoreList[typeB]!!


            if (typeAScore > typeBScore) {
                answer += typeA
            } else if (typeAScore == typeBScore) {
                val sortedType = mutableListOf(typeA, typeB)
                answer += sortedType[0]
            } else {
                answer += typeB
            }


        }
        return answer
    }
}