package me.codeninja55.theater.data

import me.codeninja55.theater.domain.Booking
import me.codeninja55.theater.domain.Performance
import me.codeninja55.theater.domain.Seat
import org.springframework.data.jpa.repository.JpaRepository

interface SeatRepository : JpaRepository<Seat, Long>

interface PerformanceRepository : JpaRepository<Performance, Long>

interface BookingRepository : JpaRepository<Booking, Long>
