package me.codeninja55.learningkotlin.kotlin.ex1

import java.util.*

data class Person(
    val title: String?,
    val firstName: String?,
    val surname: String?,
    val dateOfBirth: Calendar?
) {
    val id: Long
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

    // Add additional components
    operator fun component5() = id
    operator fun component6() = age
    operator fun component7() = favouriteColor

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