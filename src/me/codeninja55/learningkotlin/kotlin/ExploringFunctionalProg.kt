package me.codeninja55.learningkotlin.kotlin

import kotlin.math.max

fun toSentenceCase(s: String) : String = s[0].toUpperCase() + s.substring(1)

fun applyFuncToString(inputStr: String, f: (String) -> String) : String = f(inputStr)

fun main(args: Array<String>) {
    println(toSentenceCase("hello"))
    // Can add the lambda as a second part outside the brackets
    val result = applyFuncToString("hello") { s -> s.toUpperCase() }
    println(result)
    // Single parameter shortcut
    println(applyFuncToString("world") { it.toUpperCase() })
    // Passing function as an object
    println(applyFuncToString("hello", ::toSentenceCase))

    val l: List<String> = listOf("tony stark", "natasha romanoff", "peter parker", "stephen strange", "steve rogers")

    // 1 -> 1 mapping
    val l2 = l.map { it.toUpperCase() }
    l2.forEachIndexed { i: Int, s: String -> println("$i $s") }

    val filterL2 = l2.filter { it.toLowerCase().startsWith("s") }
    println(filterL2)

    // 1 -> 0..N mapping
    val flatL2 = l.flatMap<String, String> { if (it.startsWith('s')) listOf(it, it) else listOf(it) }
    println(flatL2)

    // convert collection to single value
    val reduceResult = l.reduce { accumulated, value -> "$accumulated, $value" }
    println(reduceResult)

    val nicknames = listOf("iron man", "black widow", "spiderman", "dr strange", "captain america")
    println(nicknames.count())

    val numbers = nicknames.map { it.length }
    println(numbers.fold(0) { accumulated, value -> accumulated + value})
    println(numbers.fold(0) { maxVal, value -> max(maxVal, value)})

    val myMap = mapOf<Int, String>(1 to "one", 2 to "two", 3 to "three")
    // (k,v) is destructuring syntax
    myMap.filter { it.value.startsWith("t") }.forEach { (k,v) -> println("$k : $v") }

}
