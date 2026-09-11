package org.polyfrost.polyplus.client

import androidx.compose.ui.graphics.Color
import org.polyfrost.oneconfig.internal.ui.themes.UIBranding
import org.polyfrost.oneconfig.internal.ui.themes.UITheme

internal object ThemeBrandingUtil {

    private val branding = UIBranding("assets/polyplus/brand/oneclient.svg")

    // Zmaj Client red/black palette
    private val background = Color(0xFF0B0B0D)
    private val sidebar = Color(0xFF10090B)
    private val chip = Color(0xFF241014)
    private val card = Color(0xFF171014)
    private val component = Color(0xFF1D1115)
    private val popup = Color(0xFF211116)
    private val border = Color(0xFF5C1A27)
    private val text = Color(0xFFF5F5F5)
    private val textSecondary = Color(0xFFB8AEB1)
    private val accentText = Color(0xFFFF334F)
    private val shadow = Color(0xFF000000)
    private val thumb = Color(0xFFE3263F)

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
