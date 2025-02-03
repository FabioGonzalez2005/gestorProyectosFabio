import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator

class WelcomeScreen(private val username: String, private val role: String) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val completedProjects = listOf("Proyecto A", "Proyecto B")

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { navigator?.push(ProjectsScreen()) },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFAFE3CF)),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Proyectos activos", color = Color.White, fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text("Historial de proyectos terminados:", fontSize = 18.sp)
            completedProjects.forEach { project ->
                Text(project, fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = { navigator?.pop() },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFAFE3CF)),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp)
            ) {
                Icon(imageVector = Icons.Default.Clear, tint = Color.White, contentDescription = "Desconectar")
                Spacer(modifier = Modifier.width(8.dp))
                Text("Desconectar", color = Color.White, fontSize = 18.sp)
            }
        }
    }
}
