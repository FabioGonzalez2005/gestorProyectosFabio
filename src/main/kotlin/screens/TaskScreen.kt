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

class TaskScreen(private val taskName: String) : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val taskDescription = "Descripción de la tarea: "
        val taskStatus = "Pendiente"
        val availableProgrammers = listOf("Programador A", "Programador B", "Programador C")
        var assignedProgrammer by remember { mutableStateOf<String?>(null) }

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
                    "Detalles de la Tarea: $taskName",
                    fontSize = 24.sp,
                    color = Color(0xFF589C94),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    "Descripción: $taskDescription",
                    fontSize = 16.sp,
                    color = Color(0xFF589C94),
                    textAlign = TextAlign.Start
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    "Estado: $taskStatus",
                    fontSize = 16.sp,
                    color = Color(0xFF589C94),
                    textAlign = TextAlign.Start
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    "Asignar Programador:",
                    fontSize = 18.sp,
                    color = Color(0xFF589C94),
                    textAlign = TextAlign.Start
                )

                // Selector de programador
                var selectedProgrammer by remember { mutableStateOf<String?>(null) }
                DropdownMenu(
                    expanded = selectedProgrammer != null,
                    onDismissRequest = { selectedProgrammer = null },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    availableProgrammers.forEach { programmer ->
                        DropdownMenuItem(onClick = { selectedProgrammer = programmer }) {
                            Text(text = programmer)
                        }
                    }
                }

                Button(
                    onClick = {
                        assignedProgrammer = selectedProgrammer
                        selectedProgrammer = null
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFAFE3CF)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("Asignar Programador", color = Color.White, fontSize = 16.sp)
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Mostrar el programador asignado
                if (assignedProgrammer != null) {
                    Text(
                        "Programador Asignado: $assignedProgrammer",
                        fontSize = 16.sp,
                        color = Color(0xFF589C94),
                        textAlign = TextAlign.Center
                    )
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
