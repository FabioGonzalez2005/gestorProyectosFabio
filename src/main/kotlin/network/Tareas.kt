package network

import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import model.Tarea // Importar el modelo Tarea
import network.NetworkUtils.httpClient

fun obtenerTareas(proyectoId: Int, onSuccessResponse: (List<Tarea>) -> Unit) {
    val url = "http://127.0.0.1:5000/tareas"
    CoroutineScope(Dispatchers.IO).launch {
        val response = httpClient.get(url) {
            contentType(ContentType.Application.Json)
            parameter("id", proyectoId)
        }

        val responseBody = response.bodyAsText()
        println(responseBody)

        if (response.status == HttpStatusCode.OK) {
            val tareas = response.body<List<Tarea>>()
            onSuccessResponse(tareas)
        } else {
            println("Error: ${response.status}, Body: $responseBody")
        }
    }
}
