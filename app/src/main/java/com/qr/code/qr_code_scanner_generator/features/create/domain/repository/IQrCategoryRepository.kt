package com.qr.code.qr_code_scanner_generator.features.create.domain.repository

import com.qr.code.qr_code_scanner_generator.features.create.domain.dto.QrCategoryResponse

interface IQrCategoryRepository {
    fun getQrCategories(): MutableList<QrCategoryResponse>
}