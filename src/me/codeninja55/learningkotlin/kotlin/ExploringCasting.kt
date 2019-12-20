package me.codeninja55.learningkotlin.kotlin

import java.math.BigDecimal
import java.util.*

fun main() {
    var result: Any

    val randNum = Random().nextInt(3)

    result = if (randNum == 1) BigDecimal(30) else "Hello"

    println("Result is currently $result")

    result = if (result is BigDecimal) {
        // Smart casting -- checking `result is BigDecimal` automatically casts it
        result.add(BigDecimal(42))
    } else {
        val tempResult = result as String
        tempResult.toUpperCase()
    }

    println("Result is now $result")
}