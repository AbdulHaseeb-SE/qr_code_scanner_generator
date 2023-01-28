package com.qr.code.qr_code_scanner_generator.features.create.domain.dto

import androidx.compose.ui.graphics.Color


data class QrCategoryResponse(
    val iconDrawableResId: Int,
    val lightColor: Color,
    val darkColor: Color,
    val shadowColor: Color,
    val qrOptionNameId: Int,
    val contentDescription: String
)