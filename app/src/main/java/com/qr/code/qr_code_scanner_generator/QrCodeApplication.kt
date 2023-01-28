package com.qr.code.qr_code_scanner_generator

import android.app.Application
import com.qr.code.qr_code_scanner_generator.features.create.di.createQrModule
import com.qr.code.qr_code_scanner_generator.home.di.bottomNavigationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class QrCodeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initializeKoin()
    }

    private fun initializeKoin() {
        startKoin {
            androidContext(this@QrCodeApplication)
            modules(
                bottomNavigationModule,
                createQrModule
            )
        }
    }
}