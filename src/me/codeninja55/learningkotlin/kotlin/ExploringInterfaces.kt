package me.codeninja55.learningkotlin.kotlin

import me.codeninja55.learningkotlin.kotlin.ex2.Seat
import java.math.BigDecimal

class UnauthorisedException(override val message: String = "") : Throwable()

interface BookingManager {

    val version: String

    fun isSeatAvailable(seat: Seat) : Boolean
    fun reserveSeat(seat: Seat, customerID: Long) : Boolean
    // Default
    fun systemStatus() = "All Operations are Functional."

}

open class BasicBookingManager(authKey: String) : BookingManager {

    override val version: String = "1.0"

    init {
        if (authKey !== "1234567890") throw UnauthorisedException("Not authorised to instantiate.")
    }

    override fun isSeatAvailable(seat: Seat): Boolean {
        return true
    }

    override fun reserveSeat(seat: Seat, customerID: Long): Boolean {
        return false
    }

}

class AdvancedBookingManager() : BasicBookingManager("1234567890"), java.io.Closeable {

    override val version: String = "2.0"

    override fun isSeatAvailable(seat: Seat): Boolean {
        return super.isSeatAvailable(seat)
    }

    override fun reserveSeat(seat: Seat, customerID: Long): Boolean {
        return super.reserveSeat(seat, customerID)
    }

    fun howManyBooks() = 10

    override fun close() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

// Extension functions
fun String.toSentenceCase() : String {
    return this[0].toUpperCase() + this.substring(1)
}

fun main(args: Array<String>) {
    println(AdvancedBookingManager().isSeatAvailable(Seat(1, 1, BigDecimal.ZERO, "")))

    val test = "test"
    println(test.toSentenceCase())

}
