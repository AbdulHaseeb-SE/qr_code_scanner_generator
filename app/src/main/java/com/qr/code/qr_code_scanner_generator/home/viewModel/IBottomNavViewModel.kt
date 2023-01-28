package com.qr.code.qr_code_scanner_generator.home.viewModel

import com.qr.code.qr_code_scanner_generator.home.domain.dto.BottomNavItemResponse
import kotlinx.coroutines.flow.Flow

interface IBottomNavViewModel {
    fun bottomNavItems() : Flow<MutableList<BottomNavItemResponse>>
    abstract fun handleError(throwable: Throwable)
}