package com.qr.code.qr_code_scanner_generator.home.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.qr.code.qr_code_scanner_generator.home.domain.dto.BottomNavItemResponse
import com.qr.code.qr_code_scanner_generator.ui.theme.Blue600
import com.qr.code.qr_code_scanner_generator.ui.theme.Gray600

@Composable
fun BottomNavBar(
    items: List<BottomNavItemResponse>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItemResponse) -> Unit
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    BottomNavigation(
        modifier = modifier.padding(horizontal = 16.dp),
        backgroundColor = Color.White,
        elevation = 0.dp,
    ) {
        items.forEach { item ->
            val currentDestination = item.route == navBackStackEntry?.destination?.route
            BottomNavigationItem(
                selected = currentDestination,
                onClick = { onItemClick(item) },
                selectedContentColor = Blue600,
                unselectedContentColor = Gray600,
                icon = {
                    Column(
                        horizontalAlignment = CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = item.name,
                            modifier = modifier
                                .height(24.dp)
                                .width(48.dp)
                                .padding(top = 8.dp)
                        )
                        Spacer(modifier = Modifier.padding(2.dp))
                        Text(
                            text = item.name,
                            fontSize = 12.sp,
                            textAlign = TextAlign.Justify
                        )
                        Spacer(modifier = Modifier.padding(2.dp))
                    }
                }
            )
        }
    }
}