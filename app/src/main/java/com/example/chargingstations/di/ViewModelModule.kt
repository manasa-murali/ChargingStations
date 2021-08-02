package com.example.chargingstations.di

import com.example.chargingstations.repository.NetworkRepository
import com.example.chargingstations.repository.UIDataMapperImpl
import com.example.chargingstations.viewmodel.StationViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
class ViewmodelModule {

    @Provides
    @ViewModelScoped
    fun provideVM(networkRepository: NetworkRepository, uiDataMapperImpl: UIDataMapperImpl): StationViewModel{
        return StationViewModel(networkRepository, uiDataMapperImpl)
    }

    @Provides
    @ViewModelScoped
    fun provideDataMapper(): UIDataMapperImpl {
        return UIDataMapperImpl()
    }
}