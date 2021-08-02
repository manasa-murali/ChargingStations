package com.example.chargingstations.repository

import com.example.chargingstations.model.StationEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface ServicePointAPI {

    @GET("/v3/poi/?")
    suspend fun fetchStationInfo(
        @Query("latitude")latitude: Double,
        @Query("longitude")longitude: Double,
        @Query("distance")distance: Int,
    ): Response<StationEntity>


}