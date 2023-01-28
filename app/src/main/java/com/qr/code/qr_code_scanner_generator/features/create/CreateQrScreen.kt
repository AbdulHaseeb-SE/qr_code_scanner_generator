package com.qr.code.qr_code_scanner_generator.features.create

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.qr.code.qr_code_scanner_generator.R
import com.qr.code.qr_code_scanner_generator.features.create.component.QrCategoryCard
import com.qr.code.qr_code_scanner_generator.features.create.component.TopAppBar
import com.qr.code.qr_code_scanner_generator.features.create.domain.dto.QrCategoryResponse
import com.qr.code.qr_code_scanner_generator.features.create.viewModel.CreateQrViewModel
import com.qr.code.qr_code_scanner_generator.ui.theme.Gray50
import com.qr.code.qr_code_scanner_generator.ui.theme.Gray800
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getKoin

@Composable
fun CreateQrScreen() {

    val qrCategoryList: MutableList<QrCategoryResponse> = mutableListOf()
    val viewModel: CreateQrViewModel = getKoin().get()

    ObserverQrCategories(
        viewModel = viewModel,
        qrCategoryList = qrCategoryList
    )

    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Color.White,
                contentColor = Gray800,
                icon = painterResource(
                    id = R.drawable.ic_arrow_back
                ),
                text = stringResource(id = R.string.create_qr),
                iconContentDescription = stringResource(id = R.string.go_back_button),
                actionIcons = {}
            )
        }) { paddingValues ->
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = paddingValues.calculateTopPadding(),
                    end = 10.dp
                )
                .background(Gray50),
            columns = GridCells.Adaptive(128.dp)
        ) {
            itemsIndexed(
                items = qrCategoryList
            ) { _, item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Gray50)
                        .padding(
                            start = 16.dp,
                            top = 12.dp,
                            end = 6.dp,
                            bottom = 4.dp
                        )
                ) {
                    SetCategoryCard(item) {}
                }
            }
        }
    }
}

@Composable
fun SetCategoryCard(
    item: QrCategoryResponse,
    itemClicked: (String) -> Unit
) {
    QrCategoryCard(
        iconDrawableId = item.iconDrawableResId,
        lightColor = item.lightColor,
        darkColor = item.darkColor,
        shadowColor = item.shadowColor,
        text = stringResource(id = item.qrOptionNameId),
        width = 1f,
        elevation = 12.dp,
        contentDescription = item.contentDescription
    ) { clickedItemText ->
        itemClicked(clickedItemText)
    }
}

@Composable
fun ObserverQrCategories(
    viewModel: CreateQrViewModel,
    qrCategoryList: MutableList<QrCategoryResponse>
) {
    SideEffect {
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.qrCategories().collectLatest {
                qrCategoryList += it
            }
        }
    }
}
