package model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("id_empleado") var idEmpleado: Int,
    @SerialName("id_gestor") var idGestor: Int,
    @SerialName("nombre") var nombre: String,
    @SerialName("email") var email: String
)