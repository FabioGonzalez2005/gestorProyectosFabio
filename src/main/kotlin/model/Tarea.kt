package model

import kotlinx.serialization.Serializable

@Serializable
data class Tarea(
    val id: Int,
    val nombre: String,
    val descripcion: String
)
