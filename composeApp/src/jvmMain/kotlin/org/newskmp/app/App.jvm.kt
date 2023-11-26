package org.newskmp.app

import java.awt.Desktop
import java.net.URI

internal actual fun openUrl(url: String?) {
    val uri = url?.let { URI.create(it) } ?: return
    Desktop.getDesktop().browse(uri)
}
actual fun isAndroid(): Boolean{
    return false
}
actual fun isJs():Boolean{
    return false
}