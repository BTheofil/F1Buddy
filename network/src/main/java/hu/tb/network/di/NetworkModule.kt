package hu.tb.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hu.tb.network.data.repository.DriverRepositoryImpl
import hu.tb.network.data.retrofit.OpenF1Api
import hu.tb.network.domain.repository.DriverRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "https://api.openf1.org/v1/"

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): OpenF1Api =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OpenF1Api::class.java)


    @Provides
    @Singleton
    fun provideDriverRepository(api: OpenF1Api): DriverRepository = DriverRepositoryImpl(network = api)

}