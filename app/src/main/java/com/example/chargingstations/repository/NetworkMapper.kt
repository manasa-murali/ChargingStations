package com.example.chargingstations.repository

import com.example.chargingstations.utils.UserLocation

interface NetworkMapper<Domain, Entity> {
    fun mapFromEntity(entity: Entity,userLocation: UserLocation): Domain

}