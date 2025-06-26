package com.example.modsentaskskonstantin.ui.posts

sealed class PostEvent {
    data class ShowError(val message: String) : PostEvent()
}
