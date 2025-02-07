package screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import model.Projects
import network.activeProjects

class ProjectsScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val coroutineScope = rememberCoroutineScope()
        var projects by remember { mutableStateOf<List<Projects>>(emptyList()) }
        var isLoading by remember { mutableStateOf(true) }
        var filter by remember { mutableStateOf("todos") }

        // Llamada a la API
        LaunchedEffect(Unit) {
            activeProjects("usuario", "password") { fetchedProjects ->
                projects = fetchedProjects
                isLoading = false
            }
        }

        val filteredProjects = projects.filter { it.name == filter || filter == "todos" }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF589C94)),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .width(400.dp)
                    .padding(20.dp)
                    .background(Color.White, shape = RoundedCornerShape(16.dp))
                    .padding(20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Proyectos Activos",
                    fontSize = 24.sp,
                    color = Color(0xFF589C94),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = { filter = "todos" },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFAFE3CF)),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text("Todos", color = Color.White, fontSize = 16.sp)
                    }
                    Button(
                        onClick = { filter = "mio" },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFAFE3CF)),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text("Mis Proyectos", color = Color.White, fontSize = 16.sp)
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                if (isLoading) {
                    CircularProgressIndicator(color = Color(0xFF589C94))
                } else if (filteredProjects.isEmpty()) {
                    Text(
                        "No hay proyectos disponibles.",
                        fontSize = 16.sp,
                        color = Color(0xFF589C94)
                    )
                } else {
                    filteredProjects.forEach { project ->
                        Button(
                            onClick = { navigator?.push(ProjectScreen(project.name, project.descripcion)) },
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFAFE3CF)),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text(
                                "${project.name}",
                                color = Color.White,
                                fontSize = 16.sp
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    onClick = { navigator?.pop() },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFAFE3CF)),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("Volver", color = Color.White, fontSize = 18.sp)
                }
            }
        }
    }
}
