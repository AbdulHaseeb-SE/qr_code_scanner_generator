package com.qr.code.qr_code_scanner_generator.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.qr.code.qr_code_scanner_generator.home.HomeScreen
import com.qr.code.qr_code_scanner_generator.home.domain.dto.BottomNavItemResponse
import com.qr.code.qr_code_scanner_generator.splash.SplashScreen
import com.qr.code.qr_code_scanner_generator.utils.constants.Graph

@Composable
fun RootNavigationGraph(
    navHostController: NavHostController,
    bottomNavItemList: MutableList<BottomNavItemResponse>
) {
    NavHost(
        navController = navHostController,
        route = Graph.Root,
        startDestination = ScreenController.Splash.route
    ) {
        composable(route = ScreenController.Splash.route) {
            SplashScreen(navController = navHostController)
        }
        composable(route = Graph.Home) {
            HomeScreen(bottomNavItemList = bottomNavItemList)
        }
    }
}
