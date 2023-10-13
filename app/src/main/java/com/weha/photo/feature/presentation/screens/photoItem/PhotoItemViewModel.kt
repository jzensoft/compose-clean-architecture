package com.weha.photo.feature.presentation.screens.photoItem

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weha.photo.core.resource.Resource
import com.weha.photo.feature.domain.PhotoRepository
import com.weha.photo.feature.presentation.screens.photoItem.state.PhotoItemState
import kotlinx.coroutines.launch

class PhotoItemViewModel(
    private val photoRepository: PhotoRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _itemState = mutableStateOf(PhotoItemState())
    val itemState: State<PhotoItemState> = _itemState

    init {
        savedStateHandle.get<String>("id")?.let {
            getPhotoById(it)
        }
    }

    private fun getPhotoById(id: String) {
        _itemState.value = PhotoItemState(isLoading = true)
        viewModelScope.launch {
            when (val res = photoRepository.getPhoto(id)) {
                is Resource.Success -> {
                    _itemState.value = PhotoItemState(isLoading = false, data = res.data!!)
                }

                else -> {
                    _itemState.value = PhotoItemState(isLoading = false, error = res.message ?: "")
                }
            }
        }
    }
}