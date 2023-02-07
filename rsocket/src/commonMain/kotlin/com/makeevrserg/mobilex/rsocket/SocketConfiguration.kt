package com.makeevrserg.mobilex.rsocket

class SocketConfiguration(
    val url: String,
    val connectTimeout: Long,
    val writeTimeout: Long,
    val readTimeout: Long,
    val headers: Map<String, String>
)



