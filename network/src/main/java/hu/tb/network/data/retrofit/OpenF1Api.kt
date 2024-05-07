package hu.tb.network.data.retrofit

import hu.tb.network.domain.model.remote.DriverDto
import hu.tb.network.domain.model.remote.SessionDto
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface OpenF1Api {

    @GET("drivers")
    suspend fun getDriverInformation(
        @Query("driver_number") driverNumber: Int,
        @Query("session_key") sessionKey: Int
    ): List<DriverDto>

    @GET
    suspend fun getSession(
        @Url dateParam: String?
    ): List<SessionDto>
}