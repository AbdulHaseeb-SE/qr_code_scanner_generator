package com.qr.code.qr_code_scanner_generator

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.qr.code.qr_code_scanner_generator.home.domain.dto.BottomNavItemResponse
import com.qr.code.qr_code_scanner_generator.home.viewModel.BottomNavViewModel
import com.qr.code.qr_code_scanner_generator.navigation.RootNavigationGraph
import com.qr.code.qr_code_scanner_generator.ui.theme.Qr_code_scanner_generatorTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lateinit var navController: NavHostController
        val bottomNavItemList: MutableList<BottomNavItemResponse> = mutableListOf()
        val viewModel: BottomNavViewModel by inject()

        setContent {
            Qr_code_scanner_generatorTheme {
                navController = rememberNavController()
                ObserverBottomNavItems(
                    viewModel,
                    bottomNavItemList = bottomNavItemList
                )
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    RootNavigationGraph(
                        navHostController = navController,
                        bottomNavItemList = bottomNavItemList
                    )
                }
            }
        }
    }

    @Composable
    fun ObserverBottomNavItems(
        viewModel: BottomNavViewModel, bottomNavItemList: MutableList<BottomNavItemResponse>
    ) {
        LaunchedEffect(key1 = true) {
            CoroutineScope(Dispatchers.IO).launch {
                viewModel.bottomNavItems().collect {
                    bottomNavItemList += it
                }
            }
        }
    }
}