package com.example.modsentaskskonstantin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.modsentaskskonstantin.ui.login.HomeScreen
import com.example.modsentaskskonstantin.ui.login.LoginScreen
import com.example.modsentaskskonstantin.ui.posts.PostScreen
import com.example.modsentaskskonstantin.ui.tasks.TaskListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "taskList"
                    ) {
                        composable("login") {
                            LoginScreen(navController)
                        }
                        composable("home") {
                            HomeScreen()
                        }
                        composable("taskList") {
                            TaskListScreen(navController)
                        }

                        composable("posts") {
                            PostScreen()
                        }
                        composable(
                            "taskDetail/{taskId}",
                            arguments = listOf(navArgument("taskId") { type = NavType.StringType })
                        ) {
                        }
                    }
                }
            }
        }
    }
}
