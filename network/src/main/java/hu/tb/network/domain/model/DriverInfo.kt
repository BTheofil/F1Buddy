package hu.tb.network.domain.model

data class DriverInfo(
    val broadcastName: String,
    val countryCode: String,
    val driverNumber: Int,
    val firstName: String,
    val fullName: String,
    val headshotUrl: String,
    val lastName: String,
    val meetingKey: Int,
    val nameAcronym: String,
    val sessionKey: Int,
    val teamColour: String,
    val teamName: String
)
