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

                if (filteredProjects.isEmpty()) {
                    Text(
                        "No hay proyectos disponibles.",
                        fontSize = 16.sp,
                        color = Color(0xFF589C94)
                    )
                } else {
                    filteredProjects.forEach { project ->
                        Button(
                            onClick = { navigator?.pop() },
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFAFE3CF)),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text(
                                "Entrar al proyecto: ${project.first}",
                                color = Color.White,
                                fontSize = 16.sp
                            )
                        }
                    }
                }
            }
        }
    }
}