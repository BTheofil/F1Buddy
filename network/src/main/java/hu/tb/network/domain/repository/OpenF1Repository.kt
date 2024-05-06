package hu.tb.network.domain.repository

import hu.tb.network.domain.model.DriverInfo
import hu.tb.network.domain.model.Session
import hu.tb.network.domain.model.SessionParam

interface OpenF1Repository {

    suspend fun getDriverInformation(
        driverNumber: Int,
        sessionKey: Int
    ): Result<DriverInfo>

    suspend fun getSession(
        sessionParam: SessionParam?
    ): Result<List<Session>>
}