package me.codeninja55.theater.data

import me.codeninja55.theater.domain.Seat
import org.springframework.data.jpa.repository.JpaRepository

interface SeatRepository : JpaRepository<Seat, Long>
