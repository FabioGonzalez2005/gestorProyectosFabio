package screens

import androidx.compose.foundation.background
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
import androidx.compose.ui.text.style.TextAlign
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator

class WelcomeScreen(private val username: String, private val role: String) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val completedProjects = listOf("Proyecto A", "Proyecto B")

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
                    "Bienvenido, $username",
                    fontSize = 25.sp,
                    color = Color(0xFF589C94),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    "Rol: $role",
                    fontSize = 18.sp,
                    color = Color(0xFF589C94),
                    textAlign = TextAlign.Center
                )

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

                Text(
                    "Historial de proyectos terminados:",
                    fontSize = 18.sp,
                    color = Color(0xFF589C94)
                )

                Spacer(modifier = Modifier.height(8.dp))

                completedProjects.forEach { project ->
                    Text(
                        project,
                        fontSize = 16.sp,
                        color = Color(0xFF589C94)
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    onClick = { navigator?.pop() },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFAFE3CF)),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        tint = Color.White,
                        contentDescription = "Desconectar"
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Desconectar", color = Color.White, fontSize = 18.sp)
                }
            }
        }
    }
}