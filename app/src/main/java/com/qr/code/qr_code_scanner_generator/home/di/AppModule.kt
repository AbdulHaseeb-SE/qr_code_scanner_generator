package com.qr.code.qr_code_scanner_generator.home.di

import com.qr.code.qr_code_scanner_generator.home.viewModel.BottomNavViewModel
import com.qr.code.qr_code_scanner_generator.home.domain.repository.BottomNavItemRepository
import com.qr.code.qr_code_scanner_generator.home.domain.repository.IBottomNavItemRepository
import org.koin.core.module.Module
import org.koin.dsl.module


val bottomNavigationModule: Module = module {
    factory<IBottomNavItemRepository> {
        BottomNavItemRepository()
    }

    factory {
        BottomNavViewModel(
            get()
        )
    }
}