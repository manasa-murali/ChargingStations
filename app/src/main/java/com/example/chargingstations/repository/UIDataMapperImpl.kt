package com.example.chargingstations.repository


import com.example.chargingstations.model.MyUIData
import com.example.chargingstations.model.StationEntity
import com.example.chargingstations.utils.Constants
import com.example.chargingstations.utils.UserLocation
import kotlin.math.abs
import kotlin.math.acos
import kotlin.math.cos
import kotlin.math.sin

class UIDataMapperImpl : NetworkMapper<MyUIData, StationEntity.StationEntityItem> {
    override fun mapFromEntity(
        entity: StationEntity.StationEntityItem,
        userLocation: UserLocation,
    ): MyUIData {
        val addressInfo = entity.addressInfo!!
        val address = StringBuilder()
        address.apply {
            if (addressInfo.addressLine1 != null) {
                append(addressInfo.addressLine1)
                append("\n")
            }
            if (addressInfo.addressLine2 != null) {
                append(addressInfo.addressLine2)
                append("\n")
            }
            if (addressInfo.town != null) {
                append(addressInfo.town)
                append("\n")
            }
            if (addressInfo.stateOrProvince != null) {
                append(addressInfo.stateOrProvince)
                append("\n")
            }
            if (addressInfo.postcode != null) {
                append(addressInfo.postcode)
            }
        }

        val distance =
            Pair(userLocation.latitude, userLocation.longitude).compute(entity.addressInfo.latitude,
                entity.addressInfo.longitude)

        val connectionCount = if (entity.connections.isNullOrEmpty()) 0 else entity.connections.size
        return MyUIData(
            id = entity.iD,
            address = address.toString(),
            stationLat = addressInfo.latitude,
            stationLong = addressInfo.longitude,
            distance = distance,
            distanceUnit = Constants.KM,
            stationName = addressInfo.title,
            isOperational = entity.statusType!!.isOperational,
            connectionCount = connectionCount
        )
    }


    private fun Pair<Double, Double>.compute(latitude: Double, longitude: Double): Double {

        val phi1 = degreeToRadians(latitude)
        val lambda1 = degreeToRadians(longitude)

        val phi2 = degreeToRadians(this.first)
        val lambda2 = degreeToRadians(this.second)

        val deltaLamba = abs(lambda2 - lambda1)

        val deltaSigma = acos((sin(phi1) * sin(phi2)) + (cos(phi1) * cos(phi2)) * cos(deltaLamba))

        return Constants.EARTH_RADIUS * deltaSigma
    }

    private fun degreeToRadians(degree: Double): Double {
        return degree * (Math.PI / 180)
    }

    fun mapFromEntityList(
        entities: StationEntity?,
        userLocation: UserLocation,
    ): List<MyUIData> {
        val list = ArrayList<MyUIData>()
        entities!!.forEach { stationEntityItem ->
            list.add(mapFromEntity(stationEntityItem, userLocation))
        }
        return list.toList()
    }
}