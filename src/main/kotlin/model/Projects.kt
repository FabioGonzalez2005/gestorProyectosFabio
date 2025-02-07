package model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Projects(
    @SerialName("nombre") val name: String,
    @SerialName("descripcion") val descripcion: String,
    @SerialName("fecha_creacion") val fechaCreacion: String,
    @SerialName("fecha_inicio") val fechaInicio: String,
    @SerialName("fecha_finalizacion") val fechaFinalizacion: String
)
