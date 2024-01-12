package com.yudhisthereal.nurturenest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.yudhisthereal.nurturenest.ui.theme.NurtureNestTheme
import com.yudhisthereal.nurturenest.ui.screens.NavigationRoutes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NurtureNestTheme {
                MainApp()
            }
        }
    }
}

@Composable
fun MainApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        MainAppNavHost()
    }
}

@Composable
fun MainAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = NavigationRoutes.Unauthenticated.NavigationRoute.route
    ) {
        // Unauthenticated user flow screens
        unauthenticatedGraph(navController = navController)

        // Authenticated user flow screens
        authenticatedGraph(navController = navController)
    }
}