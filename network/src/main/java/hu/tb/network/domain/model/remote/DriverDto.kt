package hu.tb.network.domain.model.remote

import hu.tb.network.domain.model.DriverInfo

data class DriverDto(
    val broadcast_name: String,
    val country_code: String,
    val driver_number: Int,
    val first_name: String,
    val full_name: String,
    val headshot_url: String,
    val last_name: String,
    val meeting_key: Int,
    val name_acronym: String,
    val session_key: Int,
    val team_colour: String,
    val team_name: String
) {

    fun toDriverInformation(): DriverInfo =
        DriverInfo(
            broadcastName = broadcast_name,
            countryCode = country_code,
            driverNumber = driver_number,
            firstName = first_name,
            fullName = full_name,
            headshotUrl = headshot_url,
            lastName = last_name,
            meetingKey = meeting_key,
            nameAcronym = name_acronym,
            sessionKey = session_key,
            teamColour = team_colour,
            teamName = team_name
        )
}