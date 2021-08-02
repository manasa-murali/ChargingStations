package com.example.chargingstations.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chargingstations.model.MyUIData
import com.example.chargingstations.model.StationEntity
import com.example.chargingstations.repository.NetworkRepository
import com.example.chargingstations.repository.UIDataMapperImpl
import com.example.chargingstations.utils.UserLocation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class StationViewModel
@Inject
constructor(
    private val networkRepository: NetworkRepository,
    private val uiDataMapperImpl: UIDataMapperImpl,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : ViewModel() {

    private val mutableUiDataFlow = MutableStateFlow<MyUIState>(MyUIState.Initial)

    val uiDataFlow = mutableUiDataFlow.asStateFlow()

    fun loadStationData(distance: Int, userLocation: UserLocation) {

        viewModelScope.launch(dispatcher) {
            mutableUiDataFlow.emit(
                MyUIState.Loading
            )
            try {
                val response =
                    networkRepository.fetchDataFromNetwork(distance, userLocation)
                if (response.isSuccessful) {
                    val body: StationEntity? = response.body()
                    val uiDataList: List<MyUIData> =
                        uiDataMapperImpl.mapFromEntityList(body!!, userLocation)
                    mutableUiDataFlow.emit(
                        MyUIState.Success(
                            uiDataList
                        )
                    )
                } else {
                    mutableUiDataFlow.emit(
                        MyUIState.Failure(
                            response.code()
                        )
                    )
                }
            } catch (e: Exception) {
                mutableUiDataFlow.emit(
                    MyUIState.Failure(
                        -1     //Default error code
                    )
                )
            }
        }
    }

    fun refreshLayout(distance: Int, userLocation: UserLocation) {
        loadStationData(distance,userLocation) // Replace the block with refresh api when available
    }
}