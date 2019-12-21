package me.codeninja55.learningkotlin.kotlin.ex1

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertEquals

class TestPerson {

    @Test
    fun testGetAgeMethod() {
        assertEquals(
            30,
            Person.getAge(GregorianCalendar(1989,5, 5))
        )
    }

    @Test
    fun testNullPtrException() {
        Assertions.assertThrows(java.lang.NullPointerException::class.java) {
            Person(
                title = "Mr",
                firstName = null,
                surname = "Null",
                dateOfBirth = null
            )
        }
        Assertions.assertThrows(java.lang.NullPointerException::class.java) {
            Person(
                title = null,
                firstName = "Nullable",
                surname = "Nuller",
                dateOfBirth = null
            )
        }
        Assertions.assertThrows(java.lang.NullPointerException::class.java) {
            Person(
                title = "Mr",
                firstName = "Nullable",
                surname = null,
                dateOfBirth = null
            )
        }
    }

    @Test
    fun testInstantiateNoDOB() {
        val ferny = Person(
            title = "Ms",
            firstName = "Fernysia",
            surname = "Intan",
            dateOfBirth = null
        )

        assertEquals(null, ferny.dateOfBirth)
        assertEquals(-1, ferny.safeAge)
    }

    @Test
    fun testAgeFromDOB() {
        val genina = Person(
            title = "Ms",
            firstName = "Genina",
            surname = "Manuel",
            dateOfBirth = GregorianCalendar(1991, 2, 25)
        )
        assertEquals(28, genina.age)
    }

    @Test
    fun testSetFavouriteColor() {
        val andru = Person(
            title = "Mr",
            firstName = "Andru",
            surname = "Che",
            dateOfBirth = GregorianCalendar(1989, 5, 5)
        )
        andru.favouriteColor = "Red"
        assertEquals("Red", andru.favouriteColor)
    }

    @Test
    fun testDestructuringAllComponents() {
        val andru = Person(
            title = "Mr",
            firstName = "Andru",
            surname = "Che",
            dateOfBirth = GregorianCalendar(1989, 5, 5)
        )
        andru.favouriteColor = "Red"
        val (title, firstName, surname, dob, _, age, favColor) = andru
        assertEquals("Mr", title)
        assertEquals("Andru", firstName)
        assertEquals("Che", surname)
        assertEquals(GregorianCalendar(1989, 5, 5), dob)
        assertEquals(30, age)
        assertEquals("Red", favColor)
    }

    @Test
    fun testColorType() {
        val andru = Person(
            title = "Mr",
            firstName = "Andru",
            surname = "Che",
            dateOfBirth = GregorianCalendar(1989, 5, 5)
        )
        andru.favouriteColor = "Red"
        assertEquals("rgb", andru.getColorType())
    }

    @Test
    fun testStringOverride() {
        val annie = Person(
            title = "Miss",
            firstName = "Annie",
            surname = "Nguyen",
            dateOfBirth = GregorianCalendar(2002, 8, 27)
        )
        assertEquals("Miss Annie Nguyen", annie.toString())
    }
}
