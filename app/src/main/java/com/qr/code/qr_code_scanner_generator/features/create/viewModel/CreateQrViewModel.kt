package com.qr.code.qr_code_scanner_generator.features.create.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qr.code.qr_code_scanner_generator.features.create.domain.dto.QrCategoryResponse
import com.qr.code.qr_code_scanner_generator.features.create.domain.repository.IQrCategoryRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus

class CreateQrViewModel(
    private val repository: IQrCategoryRepository
) : ViewModel(), ICreateQrViewModel {

    private val qrCategories =
        MutableStateFlow<MutableList<QrCategoryResponse>>(mutableListOf())

    private val baseViewModelScope = viewModelScope + CoroutineExceptionHandler { _, throwable ->
        handleError(throwable)
    }

    init {
        baseViewModelScope.launch {
            val items = repository.getQrCategories()
            qrCategories.value = items
        }
    }

    override fun qrCategories(): Flow<MutableList<QrCategoryResponse>> = qrCategories

    override fun handleError(throwable: Throwable) {
    }

}