package me.codeninja55.theater.control

import me.codeninja55.theater.data.PerformanceRepository
import me.codeninja55.theater.data.SeatRepository
import me.codeninja55.theater.domain.Booking
import me.codeninja55.theater.domain.Performance
import me.codeninja55.theater.domain.Seat
import me.codeninja55.theater.services.BookingService
import me.codeninja55.theater.services.TheaterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.ModelAndView

@Controller
class MainController {
    @RequestMapping("helloWorld")
    fun helloWorld() : ModelAndView = ModelAndView("helloWorld")

    @Autowired
    lateinit var theaterService: TheaterService

    @Autowired
    lateinit var bookingService: BookingService

    @Autowired
    lateinit var seatRepository: SeatRepository

    @Autowired
    lateinit var performanceRepository: PerformanceRepository

    @RequestMapping("/")
    fun homePage() : ModelAndView {
        val model = mapOf<String, Any>(
            "bean" to CheckAvailabilityBackingBean(),
            "performances" to performanceRepository.findAll(),
            "seatNums" to 1..36,
            "seatRows" to 'A'..'O'
        )
        return ModelAndView(
            "seatBooking",
            model
        )
    }


    @RequestMapping(value = ["checkAvailability"], method = [RequestMethod.POST])
    fun checkAvailability(bean: CheckAvailabilityBackingBean) : ModelAndView {
        val selectedSeat: Seat = bookingService.findSeat(bean.selectedSeatNum, bean.selectedSeatRow)!!
        val selectedPerformance: Performance = performanceRepository.findById(bean.selectedPerformance!!).get()

        bean.seat = selectedSeat
        bean.performance = selectedPerformance
        bean.available = bookingService.isSeatFree(selectedSeat, selectedPerformance)

        return ModelAndView("seatBooking", "bean", bean)
    }

    /**
     * API endpoint for bootstrapping the database with seats.
     */
    /*@RequestMapping("bootstrap")
    fun createInitialData() : ModelAndView {
        // create the data and save it to the database
        val seats = theaterService.seats
        seatRepository.saveAll(seats)
        return homePage()
    }*/
}

class CheckAvailabilityBackingBean() {
    var selectedSeatNum: Int = 1
    var selectedSeatRow: Char = 'A'
    var selectedPerformance: Long? = null
    var customerName: String = ""
    var available: Boolean? = null
    var seat: Seat? = null
    var performance: Performance? = null
    var booking: Booking? = null
}