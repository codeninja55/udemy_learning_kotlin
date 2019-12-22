package me.codeninja55.theater.services

import me.codeninja55.theater.data.BookingRepository
import me.codeninja55.theater.data.SeatRepository
import me.codeninja55.theater.domain.Performance
import me.codeninja55.theater.domain.Seat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BookingService {

    @Autowired
    lateinit var bookingRepo: BookingRepository
    @Autowired
    lateinit var seatRepo: SeatRepository

    fun isSeatFree(seat: Seat, performance: Performance) : Boolean {
        val bookings = bookingRepo.findAll()
        val matchedBookings = bookings.filter { it.seat == seat && it.performance == performance }
        return matchedBookings.isEmpty()
    }

    fun findSeat(seatNum: Int, seatRow: Char) : Seat? {
        val seats = seatRepo.findAll()
        return seats.firstOrNull { it.seatNum == seatNum && it.seatRow == seatRow }
    }

}