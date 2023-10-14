package com.weha.photo.feature.data.repository.datasourceImpl

import com.weha.photo.core.resource.Resource
import com.weha.photo.feature.data.model.PhotoItem
import com.weha.photo.feature.data.remote.PhotoApi
import com.weha.photo.feature.data.repository.datasource.PhotoRemoteDatasource

class PhotoRemoteDatasourceImpl(
    private val photoApi: PhotoApi
) : PhotoRemoteDatasource {
    override suspend fun getPhotos(): Resource<List<PhotoItem>> {
        try {
            val res = photoApi.getPhotos()
            val body = res.body()
            if (body != null) {
                val data = mutableListOf<PhotoItem>()
                body.forEach { data.add(it) }
                return Resource.Success(body)
            }
            return Resource.Error(res.message())
        } catch (e: Exception) {
            return Resource.Error(e.message ?: "")
        }
    }

    override suspend fun getPhoto(id: String): Resource<PhotoItem> {
        try {
            val res = photoApi.getPhoto(id)
            val body = res.body()
            if (body != null) {
                return Resource.Success(body)
            }
            return Resource.Error(res.message())
        } catch (e: Exception) {
            return Resource.Error(e.message ?: "")
        }
    }
}