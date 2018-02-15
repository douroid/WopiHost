package cn.nextours.springboot.wopi.domain

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.commons.codec.binary.Base64
import java.io.StringWriter

data class WopiAccessToken(val editable: Boolean = false) {

    override fun toString(): String {
        val writer = StringWriter()
        ObjectMapper().writeValue(writer, this)
        return Base64.encodeBase64URLSafeString(writer.toString().toByteArray())
    }

    companion object {
        fun valueOf(content: String): WopiAccessToken {
            val bytes = Base64.decodeBase64(content)
            return ObjectMapper().readValue(bytes, WopiAccessToken::class.java)
        }
    }
}