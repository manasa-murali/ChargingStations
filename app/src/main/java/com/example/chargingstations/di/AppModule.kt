package com.example.chargingstations.di

import com.example.chargingstations.BuildConfig
import com.example.chargingstations.repository.ServicePointAPI
import com.example.chargingstations.utils.Constants
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesOkHttp(): OkHttpClient{
        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.addInterceptor { chain ->
            val request = chain.request().newBuilder()
            request.addHeader(Constants.HEADER_KEY,BuildConfig.API_KEY)
            (chain.proceed(request.build()))
        }
        return okHttpClient.build()
    }

    @Provides
    @Singleton
    fun providesRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun providesGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    fun providesStationService(retrofit: Retrofit): ServicePointAPI{
        return retrofit.create(ServicePointAPI::class.java)
    }
}