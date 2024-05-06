package hu.tb.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hu.tb.network.data.repository.OpenF1RepositoryImpl
import hu.tb.network.data.retrofit.OpenF1Api
import hu.tb.network.domain.repository.OpenF1Repository
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
    fun provideDriverRepository(openF1Api: OpenF1Api, ): OpenF1Repository = OpenF1RepositoryImpl(openF1Api = openF1Api)

}