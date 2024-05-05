package hu.tb.network.domain.repository

import hu.tb.network.domain.model.DriverInfo
import hu.tb.network.domain.model.SessionInfo

interface DriverRepository {

    suspend fun getDriverInformation(
        driverNumber: Int,
        sessionKey: Int
    ): Result<DriverInfo>

    suspend fun getDriverInformation(
        dateStart: String,
        dateEnd: String
    ): Result<List<SessionInfo>>
}