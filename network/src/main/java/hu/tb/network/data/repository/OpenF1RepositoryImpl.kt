package hu.tb.network.data.repository

import hu.tb.network.data.retrofit.OpenF1Api
import hu.tb.network.domain.model.DriverInfo
import hu.tb.network.domain.model.Session
import hu.tb.network.domain.model.SessionParam
import hu.tb.network.domain.repository.OpenF1Repository

class OpenF1RepositoryImpl(
    private val openF1Api: OpenF1Api,
) : OpenF1Repository {

    override suspend fun getDriverInformation(
        driverNumber: Int,
        sessionKey: Int
    ): Result<DriverInfo> =
        try {
            val dto = openF1Api.getDriverInformation(driverNumber, sessionKey)
            Result.success(dto
                .map { it.toDriverInformation() }
                .first()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }

    override suspend fun getSession(
        sessionParam: SessionParam?
    ): Result<List<Session>> =
        try {
            val sessionsList =
                if (sessionParam?.dateParam != null) {
                    openF1Api.getSession(
                        "sessions?date_start>=" + sessionParam.dateParam.startDate + "&" +
                                "date_end<=" + sessionParam.dateParam.endData,
                    )
                } else if (sessionParam?.year != null) {
                    openF1Api.getSession("sessions?year=" + sessionParam.year)
                } else {
                    openF1Api.getSession("sessions")
                }

            Result.success(
                sessionsList.map { it.toSessionInfo() }
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
}
