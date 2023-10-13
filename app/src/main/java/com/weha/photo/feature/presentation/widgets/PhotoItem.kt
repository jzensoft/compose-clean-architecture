package com.weha.photo.feature.presentation.widgets

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.weha.photo.core.utils.clickableSingle

@Composable
fun PhotoItem(title: String, onClick: () -> Unit?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickableSingle {
                onClick.invoke()
            }
            .padding(20.dp)
    ) {
        Text(text = title)
    }
}