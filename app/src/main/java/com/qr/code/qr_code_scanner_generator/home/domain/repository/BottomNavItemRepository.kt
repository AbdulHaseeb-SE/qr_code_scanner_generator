package com.qr.code.qr_code_scanner_generator.home.domain.repository

import com.qr.code.qr_code_scanner_generator.R
import com.qr.code.qr_code_scanner_generator.home.domain.dto.BottomNavItemResponse
import com.qr.code.qr_code_scanner_generator.navigation.ScreenController

class BottomNavItemRepository : IBottomNavItemRepository {
    override fun getBottomNavItems(): MutableList<BottomNavItemResponse> = mutableListOf(
        BottomNavItemResponse(
            name = "Scan",
            route = ScreenController.Scan.route,
            icon = R.drawable.ic_scan_qr
        ),
        BottomNavItemResponse(
            name = "Create",
            route = ScreenController.Create.route,
            icon = R.drawable.ic_create_qr
        ),
        BottomNavItemResponse(
            name = "History",
            route = ScreenController.History.route,
            icon = R.drawable.ic_history
        ),
        BottomNavItemResponse(
            name = "Setting",
            route = ScreenController.Setting.route,
            icon = R.drawable.ic_setting
        ),
    )
}