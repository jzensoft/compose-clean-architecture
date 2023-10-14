package com.weha.photo.feature.data.repository.datasource

import com.weha.photo.core.resource.Resource
import com.weha.photo.feature.data.model.PhotoItem

interface PhotoRemoteDatasource {
    suspend fun getPhotos(): Resource<List<PhotoItem>>
    suspend fun getPhoto(id: String): Resource<PhotoItem>
}