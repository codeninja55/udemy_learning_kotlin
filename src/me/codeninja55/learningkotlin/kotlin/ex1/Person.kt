package me.codeninja55.learningkotlin.kotlin.ex1

import java.util.*

data class Person(
    val id: Long?,
    val title: String?,
    val firstName: String?,
    val surname: String?,
    val dateOfBirth: Calendar?
) {
    val age: Int
        get() = getAge(this.dateOfBirth)

    init {
        if (id == null || title == null || firstName == null || surname == null)
            throw NullPointerException()
    }

    companion object {
        fun getAge(dateOfBirth: Calendar?) : Int {
            if (dateOfBirth == null) return -1

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
        id = 1L,
        title = "Miss",
        firstName = "Annie",
        surname = "Nguyen",
        dateOfBirth = GregorianCalendar(2002, 8, 27)
    )

    val genina = Person(
        id = 2L,
        title = "Ms",
        firstName = "Genina",
        surname = "Manuel",
        dateOfBirth = GregorianCalendar(1991, 2, 25)
    )

    val ferny = Person(
        id = 3L,
        title = "Ms",
        firstName = "Fernysia",
        surname = "Intan",
        dateOfBirth = null
    )

    try {
        Person(
            id = 4L,
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
}
