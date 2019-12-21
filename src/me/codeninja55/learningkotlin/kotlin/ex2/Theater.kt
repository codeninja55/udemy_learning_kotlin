package me.codeninja55.learningkotlin.kotlin.ex2

import java.math.BigDecimal

/**
 * The [Theater] class is a data object that contains 15 rows of 36 [Seat] each with different pricing and descriptions.
 * @constructor Instantiates the Theater object with all its seats based on the business case.
 */
class Theater {
    private val _seats = mutableListOf<Seat>()
    /**
     * An immutable list of seats for the theater with a public getter method.
     */
    val seats: List<Seat>
        get() : List<Seat> = _seats.toList()

    init {
        /**
         * Return the price of the seat based on the row and seat number.
         */
        fun getPrice(row: Int, num: Int) : BigDecimal {
            return when {
                row >= 14 -> BigDecimal(14.50)
                num <= 3 || num >= 34 -> BigDecimal(16.50)
                row == 1 -> BigDecimal(21)
                else -> BigDecimal(18)
            }
        }

        /**
         * Return the description of the seat section based on the row and seat number.
         */
        fun getDescription(row: Int, num: Int) : String {
            return when {
                row == 15 -> "Back row"
                row == 14 -> "Cheaper seat"
                num <= 3 || num >= 34 -> "Restricted view"
                row <= 2 -> "Best view"
                else -> "Standard seat"
            }
        }

        for (row in 1..15) {
            for (seatNum in 1..36) {
                _seats.add(
                    Seat(
                        row = row,
                        num = seatNum,
                        price = getPrice(row, seatNum),
                        description = getDescription(row, seatNum)
                    )
                )
            }

        }
    }
}

/**
 * A `Seat` is a data object that contains information about each seat in the form of rows and seat number, its price
 * and a description of the seat.
 *
 * @property row The row number of the seat.
 * @property num The seat number.
 * @property price The price of the seat based on its position.
 * @property description A description of the seat based on its position.
 * @constructor Instantiates the Seat data object and stores its properties.
 */
data class Seat (val row: Int, val num: Int, val price: BigDecimal, val description: String) {
    /** Return the string representation of the class */
    override fun toString(): String = "Seat $row-$num $$price ($description)"
}

/**
 * Testing Unit
 */
fun main(args: Array<String>) {
    val cheapSeats = Theater().seats.filter { it.price == BigDecimal(14.50) }
    for (seat in cheapSeats) println (seat)
}