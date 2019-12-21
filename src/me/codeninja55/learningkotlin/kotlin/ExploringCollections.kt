package me.codeninja55.learningkotlin.kotlin

fun main(args: Array<String>) {
    // Immutable list
    val colors = listOf<String>("Red", "Green", "Blue")
    val days = mutableListOf<String>("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    colors.forEach { x -> println(x.toUpperCase()) }
    val months = setOf<String>("Jan", "Feb", "Mar", "Apr", "May")
    val monthsNums = mapOf<Int, String>( 1 to "January", 2 to "February", 3 to "March", 4 to "April")

    // Mutable objects but of fixed size type
    val intArr = arrayOf(1, 2, 3, 4, 5)
    intArr.set(0, 0)
    println(intArr[0])
}