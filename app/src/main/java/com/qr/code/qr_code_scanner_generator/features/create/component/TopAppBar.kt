package com.qr.code.qr_code_scanner_generator.features.create.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TopAppBar(
    backgroundColor: Color,
    contentColor: Color,
    icon: Painter,
    text: String,
    iconContentDescription: String,
    actionIcons: @Composable() (RowScope.() -> Unit),
    modifier: Modifier = Modifier
) {
    androidx.compose.material.TopAppBar(
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(
                    modifier = modifier.size(18.dp),
                    painter = icon,
                    contentDescription = iconContentDescription
                )
            }
        },
        title = {
            Text(
                text = text,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        },
        actions = actionIcons
    )
}