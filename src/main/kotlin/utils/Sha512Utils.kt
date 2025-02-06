package utils

import java.security.MessageDigest

fun sha512(text: String): String{
    val md = MessageDigest.getInstance("SHA-512")
    val digest = md.digest(text.toByteArray())
    val sb = StringBuilder()
    for (i in digest.indices){
        sb.append(((digest[i].toInt() and 0xff) + 0x100).toString(16).substring(1))
    }
    return sb.toString()
}
