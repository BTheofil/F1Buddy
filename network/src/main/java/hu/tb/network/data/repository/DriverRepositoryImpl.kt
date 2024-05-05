package hu.tb.network.data.repository

import hu.tb.network.data.retrofit.OpenF1Api
import hu.tb.network.domain.model.DriverInformation
import hu.tb.network.domain.repository.DriverRepository

class DriverRepositoryImpl(
    private val network: OpenF1Api
) : DriverRepository {

    override suspend fun getDriverInformation(
        driverNumber: Int,
        sessionKey: Int
    ): Result<DriverInformation> =
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
}