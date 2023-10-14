package com.weha.photo.config.screen

sealed class Screen(val route: String) {
    object PhotoScreen : Screen("photo")
    object PhotoItemScreen : Screen("photo/item")
}