package twentyfive.june.twentysixth

fun solution(friends: Array<String>, gifts: Array<String>): Int {
    val n = friends.size
    val nameToIndex = friends.withIndex().associate { it.value to it.index }

    val giftMatrix = Array(n) { IntArray(n) }  // A -> B 선물 횟수
    val giftGiven = IntArray(n)               // 총 준 선물
    val giftReceived = IntArray(n)            // 총 받은 선물

    // 선물 기록 반영
    for (gift in gifts) {
        val (giver, receiver) = gift.split(" ")
        val gi = nameToIndex[giver]!!
        val ri = nameToIndex[receiver]!!

        giftMatrix[gi][ri] += 1
        giftGiven[gi] += 1
        giftReceived[ri] += 1
    }

    // 선물 지수 계산
    val giftScores = IntArray(n) { i -> giftGiven[i] - giftReceived[i] }

    val nextMonthGifts = IntArray(n)

    for (i in 0 until n) {
        for (j in 0 until n) {
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

    return nextMonthGifts.maxOrNull() ?: 0
}