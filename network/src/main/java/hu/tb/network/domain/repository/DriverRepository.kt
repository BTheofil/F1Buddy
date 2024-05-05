package hu.tb.network.domain.repository

import hu.tb.network.domain.model.DriverInformation

interface DriverRepository {

    suspend fun getDriverInformation(
        driverNumber: Int,
        sessionKey: Int
    ): Result<DriverInformation>
}