package com.example.chargingstations

import com.example.chargingstations.model.MyUIData
import com.example.chargingstations.model.StationEntity
import com.example.chargingstations.repository.NetworkRepository
import com.example.chargingstations.repository.ServicePointAPI
import com.example.chargingstations.repository.UIDataMapperImpl
import com.example.chargingstations.viewmodel.MyUIState
import com.example.chargingstations.utils.UserLocation
import com.example.chargingstations.viewmodel.StationViewModel
import com.google.gson.Gson
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import okhttp3.ResponseBody
import org.junit.Assert
import org.junit.Test
import retrofit2.Response

internal class StationViewModelTest {

    private val service = mockk<ServicePointAPI>()
    private val repository = NetworkRepository(service)
    private val userLocation = UserLocation(52.526, 13.415)
    private val distance = 5

    private val uiDataMapper = UIDataMapperImpl()

    @ExperimentalCoroutinesApi
    private val viewModel: StationViewModel =
        StationViewModel(repository, uiDataMapper, TestCoroutineDispatcher())

    @ExperimentalCoroutinesApi
    @Test
    fun `test Loading State`() = runBlockingTest {
        //Arrange
        val currentState = mutableListOf<MyUIState>()
        val job = launch {
            viewModel.uiDataFlow.toList(currentState)
        }

        //Act
        viewModel.loadStationData(distance, userLocation)

        //Assert
        val state = currentState[currentState.size - 2]
        assert(state is MyUIState.Loading)

        job.cancel()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `test Success State`() = runBlockingTest {

        //Arrange
        val currentState = mutableListOf<MyUIState>()
        val job = launch {
            viewModel.uiDataFlow.toList(currentState)
        }

        val stationData = Gson().fromJson(successData, StationEntity::class.java)

        coEvery {
            repository.fetchDataFromNetwork(distance, userLocation)
        } returns Response.success(stationData)

        val outputData = MyUIData(id = 87439,
            address = "Karl-Liebknecht-Straße 29\n" +
                    "Mitte\n" +
                    "Berlin\n" +
                    "Berlin\n" +
                    "10178",
            stationLat = 52.524438232115585,
            stationLong = 13.412951344982966,
            distance = 0.22218677094423894,
            distanceUnit = "km",
            stationName = "Karl-Liebknecht-Straße",
            isOperational = true,
            connectionCount = 1)

        //Act
        viewModel.loadStationData(distance, userLocation)

        //Assert
        val state = currentState.last()
        assert(state is MyUIState.Success)
        val successState = state as MyUIState.Success
        Assert.assertEquals(successState.myUIDataList, listOf(outputData))

        job.cancel()

    }

    @ExperimentalCoroutinesApi
    @Test
    fun `test Failure State`() = runBlockingTest {
        //Arrange
        val currentState = mutableListOf<MyUIState>()
        val job = launch {
            viewModel.uiDataFlow.toList(currentState)
        }
        val errorCode = 404

        coEvery {
            repository.fetchDataFromNetwork(distance, userLocation)
        } returns Response.error(errorCode, ResponseBody.create(null,"Server down"))

        //Act
        viewModel.loadStationData(distance, userLocation)

        //Assert
        val state = currentState.last()
        assert(state is MyUIState.Failure)

        val failureState = state as MyUIState.Failure
        Assert.assertEquals(failureState.errorCode, errorCode)
        job.cancel()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `test for Refresh`() = runBlockingTest {

        //Arrange
        val currentState = mutableListOf<MyUIState>()
        val job = launch {
            viewModel.uiDataFlow.toList(currentState)
        }

        val stationData = Gson().fromJson(successData, StationEntity::class.java)

        coEvery {
            repository.fetchDataFromNetwork(distance, userLocation)
        } returns Response.success(stationData)

        val outputData = MyUIData(id = 87439,
            address = "Karl-Liebknecht-Straße 29\n" +
                    "Mitte\n" +
                    "Berlin\n" +
                    "Berlin\n" +
                    "10178",
            stationLat = 52.524438232115585,
            stationLong = 13.412951344982966,
            distance = 0.22218677094423894,
            distanceUnit = "km",
            stationName = "Karl-Liebknecht-Straße",
            isOperational = true,
            connectionCount = 1)

        //Act
        viewModel.refreshLayout(distance, userLocation)

        //Assert
        val state = currentState.last()
        assert(state is MyUIState.Success)
        val successState = state as MyUIState.Success
        Assert.assertEquals(successState.myUIDataList, listOf(outputData))

        job.cancel()

    }
}