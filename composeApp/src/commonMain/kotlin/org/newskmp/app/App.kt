package org.newskmp.app

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import org.newskmp.app.theme.AppTheme
import org.newskmp.app.ui.screen.smallscreen.home.HomeScreen

@Composable
internal fun App() = AppTheme {
    Navigator(HomeScreen())
}


internal expect fun openUrl(url: String?)
expect fun isAndroid(): Boolean