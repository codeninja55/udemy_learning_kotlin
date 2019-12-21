package me.codeninja55.theater.services

import me.codeninja55.theater.domain.Seat
import org.springframework.stereotype.Service

@Service
class BookingService {

    fun isSeatFree(seat: Seat) : Boolean {
        return true
    }

}