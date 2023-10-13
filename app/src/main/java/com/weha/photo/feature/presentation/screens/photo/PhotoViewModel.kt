package com.weha.photo.feature.presentation.screens.photo

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weha.photo.core.resource.Resource
import com.weha.photo.feature.domain.PhotoRepository
import com.weha.photo.feature.presentation.screens.photo.state.PhotoState
import kotlinx.coroutines.launch

class PhotoViewModel(
    private val photoRepository: PhotoRepository
) : ViewModel() {

    private val _photoState = mutableStateOf(PhotoState())
    val photoState: State<PhotoState> = _photoState

    init {
        getPhotos()
    }

    private fun getPhotos() {
        viewModelScope.launch {
            when (val res = photoRepository.getPhotos()) {
                is Resource.Success -> {
                    _photoState.value = PhotoState(isLoading = false, photo = res.data!!)
                }

                else -> {
                    _photoState.value = PhotoState(isLoading = false, error = res.message ?: "")
                }
            }
        }
    }
}