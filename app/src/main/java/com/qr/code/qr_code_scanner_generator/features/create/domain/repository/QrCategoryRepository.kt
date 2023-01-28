package com.qr.code.qr_code_scanner_generator.features.create.domain.repository

import com.qr.code.qr_code_scanner_generator.R
import com.qr.code.qr_code_scanner_generator.features.create.domain.dto.QrCategoryResponse
import com.qr.code.qr_code_scanner_generator.ui.theme.*

class QrCategoryRepository : IQrCategoryRepository {
    override fun getQrCategories(): MutableList<QrCategoryResponse> = mutableListOf(
        QrCategoryResponse(
            iconDrawableResId = R.drawable.ic_text,
            lightColor = SeaGreenLight100,
            darkColor = SeaGreenDark300,
            shadowColor = SeaGreenShadow200,
            qrOptionNameId = R.string.text,
            contentDescription = "Card to generate Qr code for some text."
        ),
        QrCategoryResponse(
            iconDrawableResId = R.drawable.ic_wifi,
            lightColor = RedLight200,
            darkColor = RedDark800,
            shadowColor = RedShadow400,
            qrOptionNameId = R.string.wifi,
            contentDescription = "Card to generate Qr code for Wifi details."
        ),
        QrCategoryResponse(
            iconDrawableResId = R.drawable.ic_contact,
            lightColor = OrangeLight100,
            darkColor = OrangeDark800,
            shadowColor = OrangeShadow900,
            qrOptionNameId = R.string.contact,
            contentDescription = "Card to generate Qr code for Contact details."
        ),
        QrCategoryResponse(
            iconDrawableResId = R.drawable.ic_message,
            lightColor = GreenLight200,
            darkColor = GreenDark500,
            shadowColor = GreenShadow500,
            qrOptionNameId = R.string.sms,
            contentDescription = "Card to generate Qr code for writing a message to someone."
        ),
        QrCategoryResponse(
            iconDrawableResId = R.drawable.ic_url,
            lightColor = BlueLight200,
            darkColor = BlueDark600,
            shadowColor = BlueShadow500,
            qrOptionNameId = R.string.url,
            contentDescription = "Card to generate Qr code for a website link."
        ),
        QrCategoryResponse(
            iconDrawableResId = R.drawable.ic_clipboard,
            lightColor = SeaBlueLight100,
            darkColor = SeaBlueDark200,
            shadowColor = SeaBlueShadow200,
            qrOptionNameId = R.string.clipboard,
            contentDescription = "Card to generate Qr code for clipboard."
        ),
        QrCategoryResponse(
            iconDrawableResId = R.drawable.ic_email,
            lightColor = YellowLight100,
            darkColor = YellowDark300,
            shadowColor = YellowShadow300,
            qrOptionNameId = R.string.email,
            contentDescription = "Card to generate Qr code for email."
        ),
        QrCategoryResponse(
            iconDrawableResId = R.drawable.ic_apps,
            lightColor = PinkLight100,
            darkColor = PinkDark300,
            shadowColor = PinkShadow300,
            qrOptionNameId = R.string.apps,
            contentDescription = "Card to generate Qr code for apps."
        ),
        QrCategoryResponse(
            iconDrawableResId = R.drawable.ic_calender,
            lightColor = RedLight200,
            darkColor = RedDark800,
            shadowColor = RedShadow400,
            qrOptionNameId = R.string.event,
            contentDescription = "Card to generate Qr code for events."
        ),
        QrCategoryResponse(
            iconDrawableResId = R.drawable.ic_card,
            lightColor = PurpleLight200,
            darkColor = PurpleDark400,
            shadowColor = PurpleShadow400,
            qrOptionNameId = R.string.card,
            contentDescription = "Card to generate Qr code for personal card."
        ),
        QrCategoryResponse(
            iconDrawableResId = R.drawable.ic_location,
            lightColor = TealLight100,
            darkColor = TealDark300,
            shadowColor = TealShadow300,
            qrOptionNameId = R.string.location,
            contentDescription = "Card to generate Qr code for location."
        ),
        QrCategoryResponse(
            iconDrawableResId = R.drawable.ic_product_code,
            lightColor = BlueLight200,
            darkColor = BlueDark600,
            shadowColor = BlueShadow500,
            qrOptionNameId = R.string.product_code,
            contentDescription = "Card to generate Qr code for product code."
        )
    )

}