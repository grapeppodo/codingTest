package `2025`.`06`.`26`

fun main() {
    val friends = listOf("muzi", "ryan", "frodo", "neo")
    val gifts = listOf(
        "muzi frodo",
        "muzi frodo",
        "ryan muzi",
        "ryan muzi",
        "ryan muzi",
        "frodo muzi",
        "frodo ryan",
        "neo muzi"
    )

    // nameToIndex: 이름 → 인덱스 변환 (빠른 조회용)
    //giftMatrix[i][j]: i번 사람이 j번 사람에게 준 선물 수
    //giftGiven[i]: i번 사람이 총 준 선물 수
    //giftReceived[i]: i번 사람이 총 받은 선물 수
    //nextMonthGifts[i]: i번 사람이 다음 달에 받을 선물 수

    // 순서
    // 1. 선물 기록 반영
    // 2. 선물 지수 계산

    // 코드 흐름
    // giftMatrix[i][j] += 1: 선물 기록을 행렬에 쌓고,
    //giftGiven[i], giftReceived[i]로 총합 계산
    //다음 달 받을 선물 수는 조건 분기해서 nextMonthGifts[i]에 저장
    //최종적으로 max()로 가장 많이 받은 수를 리턴

    val nameToIndex = friends.withIndex().associate { it.value to it.index }

    val giftMatrix = Array(friends.size) { IntArray(friends.size) }
    val giftGiven = IntArray(friends.size) // [0,0,0,0,]
    val giftReceived = IntArray(friends.size) // [0,0,0,0,]

    for (i in gifts.indices) {
        val gift = gifts[i].split(" ")

        val gi = gift.first()
        val re = gift.last()

        val giver = nameToIndex[gi]
        val receiver = nameToIndex[re]

        giftMatrix[giver!!][receiver!!] += 1
        giftGiven[giver!!] += 1
        giftReceived[receiver!!] += 1

    }

    val giftScores = IntArray(friends.size)
    for (i in friends.indices) {
        giftScores[i] = giftGiven[i] - giftReceived[i]
    }

    // nextMonthGifts
    val nextMonthGifts = IntArray(friends.size)
    for (i in friends.indices) {
        for (j in friends.indices) {
            if (i == j) continue

            val aToB = giftMatrix[i][j]
            val bToA = giftMatrix[j][i]

            if (aToB > bToA) {
                nextMonthGifts[i] += 1
            } else if (aToB == bToA) {
                if (giftScores[i] > giftScores[j]) {
                    nextMonthGifts[i] += 1
                }
            }
        }
    }

    println(nextMonthGifts.maxOrNull() ?: 0)
}