package utils

import java.security.MessageDigest

fun sha512(text: String): String{
    val md = MessageDigest.getInstance("SHA-512")
    val digest = md.digest(text.toByteArray())
    val sb = StringBuilder()
    for (byte in digest){
        sb.append(String.format("%02x", byte))
    }
    return sb.toString()
}
