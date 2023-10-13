package com.weha.photo.feature.presentation.screens.photo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.weha.photo.config.route.Screen
import com.weha.photo.core.utils.clickableSingle
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
                .fillMaxWidth()
                .padding(innerPadding)
        ) {
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(photoState.photo.size) {
                    val photo = photoState.photo[it]
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickableSingle {
                                navController.navigate(Screen.PhotoItemScreen.route + "/${photo.id}")
                            }
                            .padding(20.dp)
                    ) {
                        Text(text = photo.title)
                    }
                }
            }
        }
    }

}