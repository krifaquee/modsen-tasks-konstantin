package com.example.modsentaskskonstantin.ui.posts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.modsentaskskonstantin.domain.usecase.GetPostsUseCase
import com.example.modsentaskskonstantin.ui.utils.SingleFlowEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PostViewModel(
    private val getPostsUseCase: GetPostsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(PostState())
    val state: StateFlow<PostState> = _state.asStateFlow()

    private val _events = SingleFlowEvent<PostEvent>(viewModelScope)
    val events = _events.flow

    init {
        loadPosts()
    }

    fun loadPosts() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            try {
                val list = getPostsUseCase()
                _state.update { it.copy(posts = list, isLoading = false) }
            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false) }
                _events.emit(PostEvent.ShowError(e.message ?: "Ошибка"))
            }
        }
    }
}
