package com.weha.photo.feature.presentation.screens.photo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.weha.photo.config.screen.Screen
import com.weha.photo.feature.presentation.widgets.PhotoItem
import org.koin.androidx.compose.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhotoScreen(
    navController: NavController,
    viewModel: PhotoViewModel = koinViewModel()
) {
    val photoState = viewModel.photoState.value
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Photo")
            })
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            if (photoState.photo.isNotEmpty()) {
                LazyColumn(modifier = Modifier.fillMaxWidth()) {
                    items(photoState.photo.size) { index ->
                        val photo = photoState.photo[index]
                        PhotoItem(title = photo.title, image = photo.thumbnailUrl) {
                            navController.navigate(Screen.PhotoItemScreen.route + "/${photo.id}")
                        }
                    }
                }
            }
            if (photoState.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}