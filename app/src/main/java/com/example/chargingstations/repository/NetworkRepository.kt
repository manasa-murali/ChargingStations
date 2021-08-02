package com.example.chargingstations.repository

import com.example.chargingstations.model.StationEntity
import com.example.chargingstations.utils.UserLocation
import retrofit2.Response
import javax.inject.Inject


class NetworkRepository
@Inject
constructor(private val servicePointAPI: ServicePointAPI) {

    suspend fun fetchDataFromNetwork(
        distance: Int,
        userLocation: UserLocation
    ): Response<StationEntity> {
        return servicePointAPI.fetchStationInfo(userLocation.latitude, userLocation.longitude, distance)
    }
}