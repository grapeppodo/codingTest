package `2025`.`06`.`26`

class Solution {
    fun solution(friends: Array<String>, gifts: Array<String>): Int {
        var answer: Int = 0

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

        answer = nextMonthGifts.maxOrNull() ?: 0
        return answer
    }
}