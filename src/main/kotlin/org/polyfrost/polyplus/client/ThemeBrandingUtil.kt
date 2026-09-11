package org.polyfrost.polyplus.client

import androidx.compose.ui.graphics.Color
import org.polyfrost.oneconfig.internal.ui.themes.UIBranding
import org.polyfrost.oneconfig.internal.ui.themes.UITheme

internal object ThemeBrandingUtil {

    private val branding = UIBranding("assets/polyplus/brand/oneclient.svg")

    // Zmaj Client red/black palette
    private val background = Color(0xFF0B0B0D).value.toLong()
    private val sidebar = Color(0xFF10090B).value.toLong()
    private val chip = Color(0xFF241014).value.toLong()
    private val card = Color(0xFF171014).value.toLong()
    private val component = Color(0xFF1D1115).value.toLong()
    private val popup = Color(0xFF211116).value.toLong()
    private val border = Color(0xFF5C1A27).value.toLong()
    private val text = Color(0xFFF5F5F5).value.toLong()
    private val textSecondary = Color(0xFFB8AEB1).value.toLong()
    private val accentText = Color(0xFFFF334F).value.toLong()
    private val shadow = Color(0xFF000000).value.toLong()
    private val thumb = Color(0xFFE3263F).value.toLong()

    @JvmStatic
    fun branded(theme: UITheme): UITheme =
        theme.copy(
            pageBackground = background,
            sidebarBackground = sidebar,
            chipBackground = chip,
            modCardBackground = card,
            componentBackground = component,
            popupBackground = popup,
            borderColor = border,
            textColor = text,
            textColorSecondary = textSecondary,
            accentTextColor = accentText,
            shadowColor = shadow,
            controlThumbColor = thumb,
            branding = branding
        )
}
