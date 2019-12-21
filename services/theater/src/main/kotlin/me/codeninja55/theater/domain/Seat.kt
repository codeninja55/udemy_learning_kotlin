package me.codeninja55.theater.domain

import java.math.BigDecimal

/**
 * A [Seat] is a data object that contains information about each seat in the
 * form of rows and seat number, its price and a description of the seat.
 *
 * @property row The row number of the seat.
 * @property num The seat number.
 * @property price The price of the seat based on its position.
 * @property description A description of the seat based on its position.
 *
 * @constructor Instantiates the Seat data object and stores its properties.
 */
data class Seat(val row: Char, val num: Int, val price: BigDecimal, val description: String) {
    override fun toString(): String = "Seat $row-$num $$price ($description)"
}