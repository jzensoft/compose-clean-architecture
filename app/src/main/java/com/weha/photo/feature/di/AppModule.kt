package com.weha.photo.feature.di

import com.weha.photo.feature.data.remote.PhotoApi
import com.weha.photo.feature.data.repository.PhotoRepositoryImpl
import com.weha.photo.feature.data.repository.datasource.PhotoRemoteDatasource
import com.weha.photo.feature.data.repository.datasourceImpl.PhotoRemoteDatasourceImpl
import com.weha.photo.feature.domain.PhotoRepository
import com.weha.photo.feature.presentation.screens.photo.PhotoViewModel
import com.weha.photo.feature.presentation.screens.photoItem.PhotoItemViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PhotoApi::class.java)

    single<PhotoApi> { retrofit }
    single<PhotoRemoteDatasource> { PhotoRemoteDatasourceImpl(get()) }
    single<PhotoRepository> { PhotoRepositoryImpl(get()) }

    viewModel { PhotoViewModel(get()) }
    viewModel { PhotoItemViewModel(get(), get()) }
}