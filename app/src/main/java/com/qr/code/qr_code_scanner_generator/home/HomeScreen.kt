package com.qr.code.qr_code_scanner_generator.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.qr.code.qr_code_scanner_generator.home.component.BottomNavBar
import com.qr.code.qr_code_scanner_generator.home.domain.dto.BottomNavItemResponse
import com.qr.code.qr_code_scanner_generator.navigation.HomeNavGraph


@Composable
fun HomeScreen(
    navHostController: NavHostController = rememberNavController(),
    bottomNavItemList: MutableList<BottomNavItemResponse> = mutableListOf()
) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                navHostController,
                bottomNavItemList
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = paddingValues.calculateTopPadding(),
                    bottom = paddingValues.calculateBottomPadding()
                )
        ) {
            HomeNavGraph(navController = navHostController)
        }
    }
}

@Composable
fun BottomNavigationBar(
    navHostController: NavHostController,
    bottomNavItemList: MutableList<BottomNavItemResponse>
) {
    Card(
        elevation = 14.dp, shape = RoundedCornerShape(
            topStart = 12.dp, topEnd = 12.dp
        )
    ) {
        BottomNavBar(
            items = bottomNavItemList, navController = navHostController
        ) { currentItem ->
            navHostController.navigate(currentItem.route) {
                launchSingleTop = true
            }
        }
    }
}


