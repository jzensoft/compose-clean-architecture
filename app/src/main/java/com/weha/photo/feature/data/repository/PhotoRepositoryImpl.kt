package com.weha.photo.feature.data.repository

import com.weha.photo.core.resource.Resource
import com.weha.photo.feature.data.model.PhotoItem
import com.weha.photo.feature.data.remote.PhotoApi
import com.weha.photo.feature.domain.PhotoRepository

class PhotoRepositoryImpl(
    private val photoApi: PhotoApi
) : PhotoRepository {
    override suspend fun getPhotos(): Resource<List<PhotoItem>> {
        val res = photoApi.getPhotos()
        val body = res.body()
        if (body != null) {
            val data = mutableListOf<PhotoItem>()
            body.forEach {
                data.add(it)
            }
            return Resource.Success(body)
        }
        return Resource.Error(res.message())
    }

    override suspend fun getPhoto(id: String): Resource<PhotoItem> {
        val res = photoApi.getPhoto(id)
        val body = res.body()
        if (body != null) {
            return Resource.Success(body)
        }
        return Resource.Error(res.message())
    }
}