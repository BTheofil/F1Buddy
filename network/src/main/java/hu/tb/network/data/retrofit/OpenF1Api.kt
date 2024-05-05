package hu.tb.network.data.retrofit

import hu.tb.network.domain.model.remote.DriverDto
import hu.tb.network.domain.model.remote.SessionDto
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenF1Api {

    @GET("drivers")
    suspend fun getDriverInformation(
        @Query("driver_number") driverNumber: Int,
        @Query("session_key") sessionKey: Int
    ): List<DriverDto>

    @GET("sessions")
    suspend fun getSessionsByTime(
        @Query("date_start") dateStart: String,
        @Query("date_end") dateEnd: String
    ): List<SessionDto>
}