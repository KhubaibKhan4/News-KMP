package org.newskmp.app

import platform.Foundation.NSURL
import platform.UIKit.UIApplication

internal actual fun openUrl(url: String?) {
    val nsUrl = url?.let { NSURL.URLWithString(it) } ?: return
    UIApplication.sharedApplication.openURL(nsUrl)
}
actual fun isAndroid(): Boolean{
    return true
}
actual fun isJs(): Boolean{
    return false
}