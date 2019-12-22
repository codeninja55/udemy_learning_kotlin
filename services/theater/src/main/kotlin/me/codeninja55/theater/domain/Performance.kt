package me.codeninja55.theater.domain

import javax.persistence.*

@Entity
data class Performance(@Id @GeneratedValue(strategy = GenerationType.AUTO)
                       val id: Long,
                       val title: String) {

    @OneToMany(mappedBy = "performance")
    lateinit var bookings: List<Booking>

    override fun toString(): String {
        return "Performance(id=$id, title='$title')"
    }
}