package hu.tb.network.data.retrofit

import hu.tb.network.domain.model.remote.DriverDto
import hu.tb.network.domain.model.remote.SessionDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url
import java.time.LocalDate

interface OpenF1Api {

    @GET("drivers")
    suspend fun getDriverInformation(
        @Query("driver_number") driverNumber: Int,
        @Query("session_key") sessionKey: Int
    ): List<DriverDto>

    //@GET("sessions/{dateParam}")
    @GET
    fun getSession(
        @Url dateParam: String?
        //@Path("dateParam") dateParam: String?,
        //@Path("endDate") dateEnd: String?,
        //@Query("date_start>") dateStart: LocalDate?,
        //@Query("date_end>") dateEnd: LocalDate?,
        //@Query("year") year: LocalDate?
    ): Call<List<SessionDto>>
}