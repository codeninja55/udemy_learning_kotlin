package me.codeninja55.theater.domain

import com.sun.istack.NotNull
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Performance(@Id @GeneratedValue(strategy = GenerationType.AUTO)
                       val id: Long,
                       @NotNull
                       val title: String) {
    override fun toString(): String {
        return "Performance(id=$id, title='$title')"
    }
}