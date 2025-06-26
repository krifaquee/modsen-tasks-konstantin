package com.example.modsentaskskonstantin.ui.posts

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.modsentaskskonstantin.ui.posts.common.LoadingIndicator
import com.example.modsentaskskonstantin.ui.posts.common.PostItem
import org.koin.androidx.compose.koinViewModel

@Composable
fun PostScreen(viewModel: PostViewModel = koinViewModel()) {
    val state by viewModel.state.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.events.collect { event ->
            when (event) {
                is PostEvent.ShowError ->
                    Toast.makeText(context, event.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    Box(Modifier.fillMaxSize()) {
        if (state.isLoading) {
            LoadingIndicator()
        } else {
            LazyColumn {
                items(state.posts) { post ->
                    PostItem(post = post) {
                    }
                }
            }
        }
    }
}
