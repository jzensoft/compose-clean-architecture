package com.weha.photo.feature.data.remote

import com.weha.photo.feature.data.model.Photo
import com.weha.photo.feature.data.model.PhotoItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PhotoApi {

    @GET("/photos")
    suspend fun getPhotos(): Response<Photo>

    @GET("/photos/{id}")
    suspend fun getPhoto(@Path("id") id: String): Response<PhotoItem>
}