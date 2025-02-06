import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import cafe.adriel.voyager.navigator.Navigator
import screens.LoginScreen

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        Navigator(LoginScreen())
    }
}
