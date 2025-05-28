package com.popcornissues.scribbledash.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.popcornissues.scribbledash.introscreens.HomeScreen
import com.popcornissues.scribbledash.introscreens.SelectDifficultyScreen
import com.popcornissues.scribbledash.drawingscreens.OneRoundWonderRoot
import kotlinx.serialization.Serializable

@Composable
fun Navigation(
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = Home
    ) {
        composable<Home> { backStackEntry ->
            HomeScreen(
                onOneRoundWonderClick = { navController.navigate(route = SelectDifficulty) },
                paddingValues = paddingValues
            )
        }
        composable<SelectDifficulty> { backStackEntry ->
            SelectDifficultyScreen(
                closeClick = { navController.popBackStack() },
                difficultyClick = { navController.navigate(route = OneRoundWonder) },
                paddingValues = paddingValues
            )
        }
        composable<OneRoundWonder> { backStackEntry ->
            OneRoundWonderRoot(
                closeClick = {
                    navController.popBackStack(route = Home, inclusive = false)
                },
                paddingValues = paddingValues
            )
        }
    }
}

@Serializable
object Home

@Serializable
object SelectDifficulty

@Serializable
object OneRoundWonder