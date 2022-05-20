package com.kashif.composedestinatiosnbottomnav.ui.bottomnav_entries

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.kashif.composedestinatiosnbottomnav.R
import com.kashif.composedestinatiosnbottomnav.ui.destinations.HomeDestination
import com.kashif.composedestinatiosnbottomnav.ui.destinations.SettingsDestination
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec

enum class BottomBarDestination(
    val direction: DirectionDestinationSpec,
    val icon: ImageVector,
    @StringRes val label: Int
) {
    Home(HomeDestination, Icons.Default.Home, R.string.home),
    Settings(SettingsDestination, Icons.Default.Settings, R.string.settings),
}