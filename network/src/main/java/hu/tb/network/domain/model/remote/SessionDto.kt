package hu.tb.network.domain.model.remote

import hu.tb.network.domain.model.Session
import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class SessionDto(
    val circuit_key: Int,
    val circuit_short_name: String,
    val country_code: String,
    val country_key: Int,
    val country_name: String,
    val date_end: String,
    val date_start: String,
    val gmt_offset: String,
    val location: String,
    val meeting_key: Int,
    val session_key: Int,
    val session_name: String,
    val session_type: String,
    val year: Int
) {
    fun toSessionInfo() =
        Session(
            circuitKey = circuit_key,
            circuitShortName = circuit_short_name,
            countryCode = country_code,
            countryKey = country_key,
            countryName = country_name,
            dateEnd = LocalDate.parse(
                date_end,
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX")
            ),
            dateStart = LocalDate.parse(
                date_start,
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX")
            ),
            gmtOffset = gmt_offset,
            location = location,
            meetingKey = meeting_key,
            sessionKey = session_key,
            sessionName = session_name,
            sessionType = session_type,
            year = year
        )
}