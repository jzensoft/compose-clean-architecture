package com.weha.photo.feature.presentation.widgets

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.weha.photo.core.utils.clickableSingle

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PhotoItem(title: String, image: String, onClick: () -> Unit?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickableSingle {
                onClick.invoke()
            }
            .padding(20.dp)
    ) {
        if (image.isNotEmpty()) {
            GlideImage(
                model = image,
                contentDescription = "",
                modifier = Modifier.padding(end = 10.dp),
             )
        }
        Text(text = title)
    }
}