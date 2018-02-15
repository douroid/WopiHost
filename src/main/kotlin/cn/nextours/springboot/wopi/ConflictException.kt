package cn.nextours.springboot.wopi

import java.net.HttpURLConnection

class ConflictException(message: String, val lock: String = "", val status: Int = HttpURLConnection.HTTP_CONFLICT) : Exception(message)