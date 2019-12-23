package me.codeninja55.theater.control

import me.codeninja55.theater.services.ReportingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import javax.websocket.server.PathParam
import kotlin.reflect.full.declaredMemberFunctions

@Controller
@RequestMapping("/reports")
class ReportsController {

    fun toSentenceCase(s: String) : String = s[0].toUpperCase() + s.substring(1)

    @Autowired
    lateinit var reportingService: ReportingService

    private fun getListOfReports() : List<String> {
        return  reportingService::class.declaredMemberFunctions.map {
            toSentenceCase(it.name).split("_").joinToString(" ")
        }
    }

    @RequestMapping("")
    fun main() = ModelAndView("reports", mapOf("reports" to getListOfReports()))

    @RequestMapping("/getReport")
    fun getReport(@PathParam("report") report: String) : ModelAndView {
        // Returns reference to a function
        val matchedReports = reportingService::class.declaredMemberFunctions.firstOrNull { it.name == report }
        val result = matchedReports?.call(reportingService) ?: ""
        return ModelAndView("reports", mapOf("reports" to getListOfReports(), "result" to result))
    }

}