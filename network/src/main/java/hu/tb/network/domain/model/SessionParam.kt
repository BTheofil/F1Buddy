package hu.tb.network.domain.model

import java.time.LocalDate

data class SessionParam(
    val dateParam: DateParam? = null,
    val year: LocalDate? = null
)

data class DateParam(
    val startDate: LocalDate,
    val endData: LocalDate
)
