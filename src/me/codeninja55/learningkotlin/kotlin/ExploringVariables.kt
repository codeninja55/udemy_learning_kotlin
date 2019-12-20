package me.codeninja55.learningkotlin.kotlin

import java.math.BigDecimal

// Functions in Kotlin can exist as top-level objects.
fun main(args: Array<String>) {

    var name: String
    val surname = "Che"


    name = if (args.isNotEmpty())
        if (args[0] == "Dinh") "Andrew" else "Random"
    else
        "Unknown"

    // Kotlin style string templating
    println("Hello $name ${surname.toUpperCase()}")
    println("Your name has ${name.length + surname.length} characters.")


    var ageInYears: Int? = args[1].toIntOrNull()
    println("Your age is $ageInYears")

    var ageInMinutes: Double = 0.0
    if (ageInYears !== null) ageInMinutes = (ageInYears * 365 * 24 * 60).toDouble()
    else ageInYears = 0
    println("Your age in minutes is $ageInMinutes")

    val ageInSeconds: BigDecimal = BigDecimal(ageInYears * 365 * 24 * 60 * 60 * 60)
    println("Your age in seconds is $ageInSeconds")


    // Multiline string with indenting method
    val story = """
        
        |It was a dark and stormy night. 
        |A foul smell crept across the city. 
        |$name wondered what time it was, and when it would be daylight.
    """.trimMargin("|")  // Use a special character to trim indenting
    // Can also use trimIndent() method.

    println(story)

    val changedStory = story.replaceAfterLast("it ", "would be dawn.")
    println(changedStory)

}
