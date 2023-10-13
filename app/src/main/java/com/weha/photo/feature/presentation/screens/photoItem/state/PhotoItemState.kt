package com.weha.photo.feature.presentation.screens.photoItem.state

import com.weha.photo.feature.data.model.PhotoItem

data class PhotoItemState(
    val isLoading: Boolean = false,
    val data: PhotoItem? = null,
    val error: String = ""
)
