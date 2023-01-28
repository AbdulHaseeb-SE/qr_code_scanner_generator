package com.qr.code.qr_code_scanner_generator.features.create.di

import com.qr.code.qr_code_scanner_generator.features.create.domain.repository.IQrCategoryRepository
import com.qr.code.qr_code_scanner_generator.features.create.domain.repository.QrCategoryRepository
import com.qr.code.qr_code_scanner_generator.features.create.viewModel.CreateQrViewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val createQrModule: Module = module {

    factory<IQrCategoryRepository> {
        QrCategoryRepository()
    }

    factory {
        CreateQrViewModel(
            get()
        )
    }
}