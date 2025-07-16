package twentyfive.june.twentyseventh

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
    val formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd")
    val todayDate = LocalDate.parse(today, formatter)

    val termMap = terms.associate {
        val (type, months) = it.split(" ")
        type to months.toInt()
    }

    val result = mutableListOf<Int>()

    for (i in privacies.indices) {
        val (date, type) = privacies[i].split(" ")
        val collectedDate = LocalDate.parse(date, formatter)
        val months = termMap[type]!!

        val endDate = collectedDate.plusMonths(months.toLong()).minusDays(1)

        if (todayDate.isAfter(endDate)) {
            result.add(i + 1)
//            println(i + 1)
        }
    }

    return result.toIntArray()
}

fun main() {
    val today = "2022.05.19"
    val formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd")

    val terms = arrayOf("A 6", "B 12", "C 3")
    val privacies = arrayOf("2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C")

    solution(today, terms, privacies)
}