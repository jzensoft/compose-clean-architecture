package com.weha.photo.feature.presentation.screens.photo.state

import com.weha.photo.feature.data.model.PhotoItem

data class PhotoState(
    val isLoading: Boolean = false,
    val photo: List<PhotoItem> = emptyList(),
    val error: String = ""
)