package com.example.elsol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.elsol.ui.theme.ElSolTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ElSolTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController  = rememberNavController()
                    NavHost(navController = navController, startDestination = "Cover"){
                        composable("Cover") { Cover(navController = navController) }
                        composable("Filled.Email") { Email() }
                        composable("Filled.Info") { Info() }
                        composable("Filled.Build") {  Cover(navController = navController) }
                    }
                }
            }
        }
    }
}
