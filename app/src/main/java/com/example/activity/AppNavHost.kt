package com.example.activity

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "pantalla1", modifier = modifier) {
        composable("pantalla1")   { Pantalla1Screen() }
        composable("pantalla2") { Pantalla2Screen() }
        composable("pantalla3") { Pantalla3Screen() }
        composable("pantalla4") { Pantalla4Screen() }
        composable("pantalla5") { Pantalla5Screen() }
        composable("pantalla6") { Pantalla6Screen() }
        composable("pantalla7") { Pantalla7Screen() }
        composable("pantalla8") { Pantalla8Screen() }
        composable("pantalla9") { Pantalla9Screen() }
        composable("pantalla10") { Pantalla10Screen() }


    }
}