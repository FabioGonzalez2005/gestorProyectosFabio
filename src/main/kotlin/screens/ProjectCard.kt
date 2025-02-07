package screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import model.Projects

@Composable
fun ProjectList(projects: List<Projects>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Text(
            text = "Historial de proyectos terminados",
            fontSize = 22.sp,
            color = Color(0xFF589C94),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(projects) { project ->
                ProjectCard(project)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun ProjectCard(project: Projects) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = 6.dp,
        backgroundColor = Color(0xFFE6F2F2)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = project.name,
                fontSize = 20.sp,
                color = Color(0xFF00796B),
                textAlign = TextAlign.Start
            )

            Text(
                text = project.descripcion,
                fontSize = 16.sp,
                color = Color(0xFF004D40)
            )

            Divider(color = Color.Gray, thickness = 1.dp)

            Text(
                text = "📅 Creación: ${project.fechaCreacion}",
                fontSize = 14.sp,
                color = Color.Gray
            )

            Text(
                text = "🚀 Inicio: ${project.fechaInicio}",
                fontSize = 14.sp,
                color = Color.Gray
            )

            Text(
                text = "✅ Finalización: ${project.fechaFinalizacion}",
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}