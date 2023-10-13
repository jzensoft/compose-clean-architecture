package com.weha.photo.config.route

sealed class Screen(val route: String) {
    object PhotoScreen : Screen("photo_screen")
    object PhotoItemScreen : Screen("photo_item_screen")
}