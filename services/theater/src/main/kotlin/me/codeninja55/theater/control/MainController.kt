package me.codeninja55.theater.control

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

    @RequestMapping("/")
    fun homePage() : ModelAndView {
        return ModelAndView(
            "seatBooking",
            "bean",
            CheckAvailabilityBackingBean()
        )
    }

    @Autowired
    lateinit var theaterService: TheaterService

    @Autowired
    lateinit var bookingService: BookingService

    @RequestMapping(value = ["checkAvailability"], method = [RequestMethod.POST])
    fun checkAvailability(bean: CheckAvailabilityBackingBean) : ModelAndView {
        val selectedSeat = theaterService.find(
            bean.selectedSeatNum, bean.selectedSeatRow
        )
        val result = bookingService.isSeatFree(selectedSeat!!)
        bean.result = "Seat $selectedSeat is ${if (result) "available" else "booked"}."
        return ModelAndView("seatBooking", "bean", bean)
    }
}

class CheckAvailabilityBackingBean() {
    val seatNums = 1..36
    val seatRows = 'A'..'O'

    var selectedSeatNum: Int = 1
    var selectedSeatRow: Char = 'A'
    var result: String = ""
}