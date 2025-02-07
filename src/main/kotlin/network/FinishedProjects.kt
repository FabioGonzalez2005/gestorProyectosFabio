package network

import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import model.LoginRequest
import model.Projects
import model.User
import network.NetworkUtils.httpClient
import utils.sha512

fun finishedProjects(usuario: String, password: String, onSuccessResponse: (List<Projects>) -> Unit) {
    val url = "http://127.0.0.1:5000/proyectos/finalizados"
    CoroutineScope(Dispatchers.IO).launch {
        val response = httpClient.get(url) {
            contentType(ContentType.Application.Json)
        }

        val responseBody = response.bodyAsText()
        println(responseBody)

        if (response.status == HttpStatusCode.OK) {
            val projects = response.body<List<Projects>>()
            onSuccessResponse(projects)
        } else {
            println("Error: ${response.status}, Body: $responseBody")
        }
    }
}
