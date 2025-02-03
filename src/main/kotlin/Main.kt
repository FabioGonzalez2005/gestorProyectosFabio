import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import cafe.adriel.voyager.navigator.Navigator

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        Navigator(LoginScreen())
    }
}
