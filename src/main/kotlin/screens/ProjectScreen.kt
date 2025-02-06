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

class ProjectScreen(private val projectName: String, private val projectDescription: String) : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        // Tareas y programadores de ejemplo
        val tasks = listOf("Tarea 1", "Tarea 2", "Tarea 3")
        val programmers = listOf("Programador A", "Programador B", "Programador C")

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
                    "Detalles del Proyecto: $projectName",
                    fontSize = 24.sp,
                    color = Color(0xFF589C94),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    "Descripción: $projectDescription",
                    fontSize = 16.sp,
                    color = Color(0xFF589C94),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    "Tareas del Proyecto:",
                    fontSize = 18.sp,
                    color = Color(0xFF589C94),
                    textAlign = TextAlign.Start
                )

                tasks.forEach { task ->
                    Button(
                        onClick = { navigator?.push(TaskScreen(task)) },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFAFE3CF)),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text("Ver Tarea: $task", color = Color.White, fontSize = 16.sp)
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