package org.newskmp.app

import kotlinx.browser.window

internal actual fun openUrl(url: String?) {
    url?.let { window.open(it) }
}
actual fun isAndroid(): Boolean{
    return false
}