package me.codeninja55.learningkotlin.kotlin

fun main(args: Array<String>) {

    var name: String? = null
    // name = "Andrew"

    // Null Safe Operator
    // if name == null, print null
    // else name.toUpperCase()
    println(name?.toUpperCase())

    if (name == null) name = "It was null"
    // Non-Null Asserted Operator
    // Assuring name is not null
    // Can causes NullPointerException
    val nonNullAsserted = name!!.toUpperCase()
    println(nonNullAsserted)

    // An instance of Nothing
    // Cannot reassign variable
    var address = null
}
