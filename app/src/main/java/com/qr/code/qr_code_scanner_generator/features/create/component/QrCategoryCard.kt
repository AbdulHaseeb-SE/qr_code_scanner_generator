package com.qr.code.qr_code_scanner_generator.features.create.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun QrCategoryCard(
    iconDrawableId: Int,
    lightColor: Color,
    darkColor: Color,
    shadowColor: Color,
    text: String,
    width: Float,
    elevation: Dp,
    contentDescription: String,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth(width)
            .clickable {
                onClick(text)
            },
        shape = RoundedCornerShape(8.dp),
        elevation = 2.dp
    ) {
        Column(
            modifier = Modifier
                .height(92.dp),
            /*.background(shadowColor)*/
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            IconCard(
                iconDrawableId,
                lightColor,
                darkColor,
                elevation,
                shadowColor,
                contentDescription
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = text,
                color = Color(0xFF3A3737),
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
fun IconCard(
    iconDrawableId: Int,
    lightColor: Color,
    darkColor: Color,
    elevation: Dp,
    shadowColor: Color,
    contentDescription: String
) {
    Card(
        modifier = Modifier
            .width(40.dp)
            .height(40.dp),
        shape = CircleShape,
        elevation = elevation,
    ) {
        Surface(
            color = shadowColor, elevation = elevation
        ) {// This block sets the custom color for the elevation
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.linearGradient(
                            listOf(
                                lightColor, darkColor
                            )
                        )
                    ), contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = iconDrawableId),
                    contentDescription = contentDescription,
                    tint = Color.White,
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                )
            }
        }
    }
}
