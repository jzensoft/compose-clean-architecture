package com.weha.photo.feature.presentation.screens.photoItem

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.koinViewModel

@Composable
fun PhotoItemScreen(
    viewModel: PhotoItemViewModel = koinViewModel()
) {
    val itemState = viewModel.itemState.value
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = itemState.data?.title ?: "")
        if (itemState.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}