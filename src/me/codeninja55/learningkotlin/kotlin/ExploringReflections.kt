package me.codeninja55.learningkotlin.kotlin

import kotlin.math.roundToInt
import kotlin.math.sqrt
import kotlin.reflect.full.declaredFunctions

fun isPrime(a: Int) : Boolean {
    val maxNumberToCheck = sqrt(a.toDouble()).roundToInt()
    for (i in 2..maxNumberToCheck) if (a % i == 0) return false
    return true
}

class NumbersCalculation {
    fun isEven(a: Int) : Boolean = (a % 2 == 0 )
    fun isOdd(a: Int) : Boolean = (a % 2 != 0)
}

fun main(args: Array<String>) {

    val list = listOf(14, 15, 16, 17, 18, 19, 20)

    // Reference to filter method from List<> class
    println(list::filter)
    println(list::class.qualifiedName)
    println(list::class.declaredFunctions)

    // Reflection passing instead of lambda
    val primeNumbers = list.filter(::isPrime)  // passing a pointer to this function
    println(primeNumbers)

    // Reflection using a class
   // val evenNumbers = list.filter(NumbersCalculation::isEven)


}