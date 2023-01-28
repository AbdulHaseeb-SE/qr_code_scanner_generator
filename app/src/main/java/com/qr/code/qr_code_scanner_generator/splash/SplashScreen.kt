package com.qr.code.qr_code_scanner_generator.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.qr.code.qr_code_scanner_generator.R
import com.qr.code.qr_code_scanner_generator.ui.theme.Blue200
import com.qr.code.qr_code_scanner_generator.ui.theme.Blue600
import com.qr.code.qr_code_scanner_generator.ui.theme.fonts
import com.qr.code.qr_code_scanner_generator.utils.GradientButton
import com.qr.code.qr_code_scanner_generator.utils.constants.Graph

@Composable
fun SplashScreen(navController: NavHostController) {
    Splash(navController)
}

@Composable
fun Splash(navController: NavHostController, modifier: Modifier = Modifier) {
    val splashLogoPainter = painterResource(R.drawable.ic_splash_qr)
    val splashLogoDescription = "Splash Screen Logo"
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.White, Blue200
                    )
                )
            ),
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .width(180.dp)
                    .height(180.dp)
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = splashLogoPainter,
                    contentDescription = splashLogoDescription,
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.padding(8.dp))
            Text(
                text = stringResource(id = R.string.qr_code),
                fontFamily = fonts,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Text(
                text = stringResource(id = R.string.generator_scanner),
                fontFamily = fonts,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }
    }
    Column(
        modifier = modifier
            .fillMaxSize(2f)
            .padding(bottom = 40.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(horizontal = 32.dp, vertical = 8.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            GradientButton(
                text = stringResource(R.string.get_started),
                textColor = Color.White,
                textSize = 14.sp,
                gradient = Brush.verticalGradient(
                    colors = listOf(
                        Blue200, Blue600
                    )
                ),
                shape = RoundedCornerShape(24.dp)
            ) {
                navController.popBackStack()
                navController.navigate(Graph.Home)
            }
        }
    }

}

@Composable
@Preview()
fun SplashPreview() {
    Splash(rememberNavController())
}
