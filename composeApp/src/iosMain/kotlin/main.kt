import androidx.compose.ui.window.ComposeUIViewController
import org.newskmp.app.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }

