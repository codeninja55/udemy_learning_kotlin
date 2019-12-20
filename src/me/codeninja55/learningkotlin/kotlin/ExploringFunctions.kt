package me.codeninja55.learningkotlin.kotlin

/*
* Top-level functions
* Public and static by default
* */
fun printAsString(msg: Any): Unit {
    println(msg)
}

private fun concatString(val1: String, val2: String) : String {
    return "$val1 $val2"
}

fun addTwoNumbers(one: Double, two: Double) : Double {
    return one + two
}

// Single expression function
fun addTwoNumbersShort(one: Double, two: Double) : Double = one + two

fun printSomeMaths(one: Double, two: Double) : Unit {
    println("$one + $two is ${one + two}")
    println("$one - $two is ${one - two}")
}

// Optional parameters with default values
fun addTwoNumbersOpt(one: Double, two: Double = 3.9) : Double {
    return one + two
}

// Lambda functions
fun methodTakesLambda(input: String, action: (String) -> Int) {
    println(action(input))
}

fun convertStringToInt(p: String) : Int {
    return p.toInt()
}

// Unit === Void
fun main(args: Array<String>): Unit {
    printAsString(concatString("Hello", "World"))
    val res = addTwoNumbers(10.0, 20.0)
    printAsString(concatString("Adding 10.0 and 20.0 equals to", res.toString()))

    println("Adding 20.0 and 30.0 equals to ${addTwoNumbersShort(20.0, 30.0)}")

    // Named parameters -- must be used for every parameter
    printSomeMaths(two = 17.3, one = 9.6)

    printAsString(addTwoNumbersOpt(10.0))

    // methodTakesLambda("10.0", convertStringToInt)
}
