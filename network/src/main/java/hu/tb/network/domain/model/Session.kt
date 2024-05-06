package hu.tb.network.domain.model

data class Session(
    val circuitKey: Int,
    val circuitShortName: String,
    val countryCode: String,
    val countryKey: Int,
    val countryName: String,
    val dateEnd: String,
    val dateStart: String,
    val gmtOffset: String,
    val location: String,
    val meetingKey: Int,
    val sessionKey: Int,
    val sessionName: String,
    val sessionType: String,
    val year: Int
)