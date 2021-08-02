package com.example.chargingstations.model


data class MyUIData(
    val id: Int,
    val address: String,
    val stationLat: Double,
    val stationLong: Double,
    val distance: Double,
    val distanceUnit: String,
    val stationName: String,
    val isOperational: Boolean,
    val connectionCount: Int
)
