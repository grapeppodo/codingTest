package twentyfive.june.twentyseventh

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun main() {
    val today = "2022.05.19"
    val formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd")
    val todayDate = LocalDate.parse(today, formatter)

    val terms = listOf("A 6", "B 12", "C 3")
    val privacies = listOf("2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C")

    val privacyMatrix = Array<Triple<String, LocalDate, Int>?>(privacies.size) { null }

    for (i in privacies.indices) {
        val privacy = privacies[i].split(" ")

        val date = privacy.first() // 2021.05.02
        val type = privacy.last() // A

        val localDate = LocalDate.parse(date, formatter)
        privacyMatrix[i] = Triple(type, localDate, 0)
    }

    for (i in terms.indices) {
        // ["A 6", "B 12"]
        val term = terms[i].split(" ")
        val type = term.first() // A
        val month = term.last().toInt() // 6

        for (j in privacyMatrix.indices) {
            val old = privacyMatrix[j]!!

            if (privacyMatrix[j]!!.first == type) {
                privacyMatrix[j] = Triple(old.first, old.second, month)
            }
        }
    }

    for (i in privacyMatrix.indices) {
        val month = privacyMatrix[i]!!.third.toLong()
        val days = month * 28.toLong()
//        val endDate = privacyMatrix[i]!!.second.plusDays(days).minusDays(1)

        val endDate = privacyMatrix[i]!!.second.plusMonths(month).minusDays(1)

        if (endDate.isBefore(todayDate)) {
            println(i + 1)
        }
    }
}