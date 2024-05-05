package hu.tb.network.data.repository

import hu.tb.network.data.retrofit.OpenF1Api
import hu.tb.network.domain.model.DriverInfo
import hu.tb.network.domain.model.SessionInfo
import hu.tb.network.domain.repository.DriverRepository

class DriverRepositoryImpl(
    private val network: OpenF1Api
) : DriverRepository {

    override suspend fun getDriverInformation(
        driverNumber: Int,
        sessionKey: Int
    ): Result<DriverInfo> =
        try {
            val dto = network.getDriverInformation(driverNumber, sessionKey)
            Result.success(dto
                .map { it.toDriverInformation() }
                .first()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }

    override suspend fun getDriverInformation(
        dateStart: String,
        dateEnd: String
    ): Result<List<SessionInfo>> =
        try {
            val dto = network.getSessionsByTime(dateStart, dateEnd)
            Result.success(dto
                .map { it.toSessionInfo() }
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }

}