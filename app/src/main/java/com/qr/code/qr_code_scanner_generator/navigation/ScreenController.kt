package com.qr.code.qr_code_scanner_generator.navigation

sealed class ScreenController(val route: String) {
    object Splash : ScreenController("splash_screen")
    object Scan : ScreenController("scan_screen")
    object Create : ScreenController("create_screen")
    object History : ScreenController("history_screen")
    object Setting : ScreenController("setting_screen")
}
