package me.codeninja55.theater.services

import me.codeninja55.theater.domain.Seat
import org.springframework.stereotype.Service
import java.math.BigDecimal

/**
 * A [TheaterService] is an object that contains a list of [Seat].
 *
 * @property _seats A private mutable list instance that stores seats.
 * @property seats A public immutable list instance of [Seat]
 *
 * @constructor Instantiates the Theater object with all its seats based on the business case.
 */
@Service
class TheaterService {
    private val _seats = mutableListOf<Seat>()
    val seats: List<Seat> get() = _seats.toList()

    init {
        /**
         * Return the price of the seat based on the row and seat number.
         */
        fun getPrice(row: Int, num: Int) : BigDecimal {
            return when {
                row >=14 -> BigDecimal(14.50)
                num <=3 || num >= 34 -> BigDecimal(16.50)
                row == 1 -> BigDecimal(21)
                else -> BigDecimal(18)
            }

        }

        /**
         * Return the description of the seat section based on the row and seat number.
         */
        fun getDescription(row: Int, num: Int) : String {
            return when {
                row == 15 -> "Back Row"
                row == 14 -> "Cheaper Seat"
                num <=3 || num >= 34 -> "Restricted View"
                row <=2 -> "Best View"
                else -> "Standard Seat"
            }
        }

        for (row in 1..15) {
            for (num in 1..36) {
                _seats.add(
                    Seat(
                        id = 0,
                        seatRow = (row+64).toChar(),
                        seatNum = num,
                        price = getPrice(row, num),
                        description = getDescription(row, num)
                    )
                )
            }
        }
    }

    fun find(num: Int, row: Char) : Seat? {
        return seats.first { it.seatRow == row && it.seatNum == num }
    }
}
