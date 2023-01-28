package com.qr.code.qr_code_scanner_generator.home.domain.repository

import androidx.compose.runtime.Composable
import com.qr.code.qr_code_scanner_generator.home.domain.dto.BottomNavItemResponse

interface IBottomNavItemRepository {
    fun getBottomNavItems() :  MutableList<BottomNavItemResponse>
}