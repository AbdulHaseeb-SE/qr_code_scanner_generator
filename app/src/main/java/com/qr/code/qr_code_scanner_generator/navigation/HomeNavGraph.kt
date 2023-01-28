package com.qr.code.qr_code_scanner_generator.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.qr.code.qr_code_scanner_generator.features.create.CreateQrScreen
import com.qr.code.qr_code_scanner_generator.features.history.HistoryScreen
import com.qr.code.qr_code_scanner_generator.features.scan.ScanScreen
import com.qr.code.qr_code_scanner_generator.features.setting.SettingScreen
import com.qr.code.qr_code_scanner_generator.utils.constants.Graph

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.Home,
        startDestination = ScreenController.Scan.route
    ) {
        composable(route = ScreenController.Scan.route) {
            ScanScreen()
        }
        composable(route = ScreenController.Create.route) {
            CreateQrScreen()
        }
        composable(route = ScreenController.History.route) {
            HistoryScreen()
        }
        composable(route = ScreenController.Setting.route) {
            SettingScreen()
        }

    }
}