package me.codeninja55.learningkotlin.kotlin.ex1

import java.util.*

data class Person(
    val title: String?,
    val firstName: String?,
    val surname: String?,
    val dateOfBirth: Calendar?
) {
    private val id: Long
    val age: Int? get() = getAge(this.dateOfBirth)
    // Elvis operator -- similar to ternary operator and does null-safety check
    val safeAge: Int get() = age ?: -1
    // Mutable variable which is nullable so we need to check for null otherwise no smart casting
    var favouriteColor: String? = null

    init {
        this.id = getNewId()
        if (title == null || firstName == null || surname == null)
            throw NullPointerException()
    }

    // Elvis operator and null-safety check to overcome smart casting for a mutable variable like color.
    fun getColor() : String = favouriteColor?.toUpperCase() ?: "NOT SET"

    // Param requires non-nullable String
    fun getLastLetter(a: String) : String = a.takeLast(1)
    /*
    * Use `let` method to iterate and run a lambda on each which has some null-checking safety to it
    * */
    fun getLastLetterOfColor() : String {
        // `it` is a shorthand for { x -> getLastLetter(x) }
        return favouriteColor?.let { getLastLetter(it) } ?: ""
    }

    fun getColorType() : String {
        val color = getColor()

        return when (color) {
            "" -> "empty"
            "RED", "GREEN", "BLUE" -> "rgb"
            else -> "other"
        }
    }

    companion object {
        private var idCounter: Long = 0
        fun getNewId() = ++idCounter

        fun getAge(dateOfBirth: Calendar?) : Int? {
            if (dateOfBirth == null) return null

            val today: Calendar = GregorianCalendar()
            val years: Int = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR)

            return if (dateOfBirth.get(Calendar.DAY_OF_YEAR) >= today.get(Calendar.YEAR))
                years - 1
            else
                years
        }
    }

    override fun toString(): String = "$title $firstName $surname"
}

fun main(args: Array<String>) {
    val annie = Person(
        title = "Miss",
        firstName = "Annie",
        surname = "Nguyen",
        dateOfBirth = GregorianCalendar(2002, 8, 27)
    )

    val genina = Person(
        title = "Ms",
        firstName = "Genina",
        surname = "Manuel",
        dateOfBirth = GregorianCalendar(1991, 2, 25)
    )

    val ferny = Person(
        title = "Ms",
        firstName = "Fernysia",
        surname = "Intan",
        dateOfBirth = null
    )

    try {
        Person(
            title = "Mr",
            firstName = null,
            surname = null,
            dateOfBirth = null
        )
    } catch (e: NullPointerException) {
        println("Exception thrown: $e")
    }

    println("$annie's age is ${annie.age}")
    println("$genina's age is ${genina.age}")
    println("$ferny's age is ${ferny.age}")

    println("The age of someone born on 5th May 1989 is" +
            " ${Person.getAge(GregorianCalendar(1989,5, 5))}")

    println("The older person is: ${if (annie.safeAge > genina.safeAge) annie else genina}")

    val andru = Person(
        title = "Mr",
        firstName = "Andru",
        surname = "Che",
        dateOfBirth = GregorianCalendar(1989, 5, 5)
    )
    andru.favouriteColor = "Red"
    println("${annie.firstName}'s favourite color is ${annie.getColor()}")
    println("${andru.firstName}'s favourite color is ${andru.getColor()}")

    println("The type of color for ${andru.firstName} is ${andru.getColorType()}")
}
