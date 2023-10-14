package com.weha.photo.feature.data.repository

import com.weha.photo.feature.data.repository.datasource.PhotoRemoteDatasource
import com.weha.photo.feature.domain.PhotoRepository

class PhotoRepositoryImpl(
    private val photoRemoteDatasource: PhotoRemoteDatasource
) : PhotoRepository {
    override suspend fun getPhotos() = photoRemoteDatasource.getPhotos()
    override suspend fun getPhoto(id: String) = photoRemoteDatasource.getPhoto(id)
}