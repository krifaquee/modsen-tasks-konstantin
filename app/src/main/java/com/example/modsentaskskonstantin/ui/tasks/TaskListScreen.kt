package com.example.modsentaskskonstantin.ui.tasks

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.koin.androidx.compose.getViewModel

@Composable
fun TaskListScreen(
    navController: NavController,
    viewModel: TaskListViewModel = getViewModel()
) {
    val tasks by viewModel.tasks.collectAsState()

    LazyColumn {
        items(tasks) { task ->
            Text(
                text = task.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate("login")
                    }
                    .padding(16.dp)
            )
        }
    }
}