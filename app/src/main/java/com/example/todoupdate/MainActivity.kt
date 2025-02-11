package com.example.todoupdate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.todoupdate.navigation.NavigationSetup
import com.example.todoupdate.ui.theme.ToDoUpdateTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        installSplashScreen()
        setContent {
            ToDoUpdateTheme {
                navController = rememberNavController()
                NavigationSetup(navController = navController)
            }
        }
    }
}
