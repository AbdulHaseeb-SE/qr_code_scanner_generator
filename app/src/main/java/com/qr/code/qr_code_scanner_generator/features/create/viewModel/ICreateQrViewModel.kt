package com.qr.code.qr_code_scanner_generator.features.create.viewModel

import com.qr.code.qr_code_scanner_generator.features.create.domain.dto.QrCategoryResponse
import kotlinx.coroutines.flow.Flow

interface ICreateQrViewModel {
    fun qrCategories(): Flow<MutableList<QrCategoryResponse>>
    abstract fun handleError(throwable: Throwable)
}