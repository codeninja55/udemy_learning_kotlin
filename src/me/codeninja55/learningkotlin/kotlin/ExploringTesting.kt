package me.codeninja55.learningkotlin.kotlin

import org.junit.jupiter.api.Assertions
import java.util.*
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException
import kotlin.test.assertEquals

class AgeCalculation {
    fun getAge(dob: Calendar) : Int {

        val today = Calendar.getInstance()

        if (dob.timeInMillis > today.timeInMillis) throw IllegalArgumentException()

        val years = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR)

        return if (dob.get(Calendar.DAY_OF_YEAR) > today.get(Calendar.DAY_OF_YEAR))
            years - 1
        else
            years
    }
}

class TestAgeCalculation {

    private val calculator = AgeCalculation()

    @Test
    fun testDobAfterToday() {
        val date = Calendar.getInstance()
        date.add(Calendar.DAY_OF_YEAR, 10)
        Assertions.assertThrows(java.lang.IllegalArgumentException::class.java) {
            calculator.getAge(date)
        }
    }

    @Test
    fun checkAgeWhenBornToday() {
        assertEquals(0, calculator.getAge(Calendar.getInstance()))
    }

    @Test
    fun checkAgeWhenBorn1000DaysAgo() {
        val date = Calendar.getInstance()
        date.add(Calendar.DAY_OF_YEAR, -1000)

        assertEquals(2, calculator.getAge(date))
    }

    @Test
    fun checkAgeWhenBorn1989() {
        assertEquals(30, calculator.getAge(GregorianCalendar(1989, 5, 5)))
    }
}
