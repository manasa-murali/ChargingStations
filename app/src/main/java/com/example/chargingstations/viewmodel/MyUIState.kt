package com.example.chargingstations.viewmodel

import com.example.chargingstations.model.MyUIData


sealed class MyUIState{
    object Initial: MyUIState()
    object Loading: MyUIState()
    data class Success(val myUIDataList: List<MyUIData>): MyUIState()
    data class Failure(val errorCode: Int): MyUIState()
}
