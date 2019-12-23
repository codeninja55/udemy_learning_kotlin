package me.codeninja55.theater.services

import me.codeninja55.theater.data.BookingRepository
import me.codeninja55.theater.data.SeatRepository
import me.codeninja55.theater.domain.Booking
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
        val matchedBookings = findBooking(seat, performance)
        return matchedBookings == null
    }

    fun reserveSeat(seat: Seat, performance: Performance, customerName: String) : Booking {
        val booking = Booking(id = 0, customerName = customerName)
        booking.seat = seat
        booking.performance = performance
        bookingRepo.save(booking)
        return booking
    }

    fun findBooking(seat: Seat, performance: Performance) : Booking? {
        val bookings = bookingRepo.findAll()
        return bookings.firstOrNull { it.seat == seat && it.performance == performance }
    }

    fun findSeat(seatNum: Int, seatRow: Char) : Seat? {
        val seats = seatRepo.findAll()
        return seats.firstOrNull { it.seatNum == seatNum && it.seatRow == seatRow }
    }

}