package me.codeninja55.theater.domain

import com.sun.istack.NotNull
import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * A [Seat] is a data object that contains information about each seat in the
 * form of rows and seat number, its price and a description of the seat.
 *
 * @property id The primary key of the [Seat] in the database.
 * @property seatRow The row number of the seat.
 * @property seatNum The seat number.
 * @property price The price of the seat based on its position.
 * @property description A description of the seat based on its position.
 *
 * @constructor Instantiates the Seat data object and stores its properties.
 */
@Entity
data class Seat(@Id @GeneratedValue(strategy = GenerationType.AUTO)
                val id: Long,
                @NotNull
                val seatRow: Char,
                @NotNull
                val seatNum: Int,
                @NotNull
                val price: BigDecimal,
                val description: String) {
    override fun toString(): String = "$seatRow-$seatNum $$price ($description)"
}