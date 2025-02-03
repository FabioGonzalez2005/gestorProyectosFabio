import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator

class ProjectsScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        val allProjects = listOf(
            "Proyecto 1" to "mio",
            "Proyecto 2" to "todos",
            "Proyecto 3" to "mio",
            "Proyecto 4" to "todos",
            "Proyecto 5" to "mio"
        )

        var filter by remember { mutableStateOf("todos") }
        val filteredProjects = allProjects.filter { it.second == filter || filter == "todos" }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Proyectos Activos", fontSize = 24.sp)
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = { filter = "todos" }) {
                    Text("Todos")
                }
                Button(onClick = { filter = "mio" }) {
                    Text("Mis Proyectos")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (filteredProjects.isEmpty()) {
                Text("No hay proyectos disponibles.")
            } else {
                filteredProjects.forEach { project ->
                    Button(
                        onClick = { navigator?.pop() },
                        modifier = Modifier.fillMaxWidth().padding(8.dp)
                    ) {
                        Text("Entrar al proyecto: ${project.first}")
                    }
                }
            }
        }
    }
}