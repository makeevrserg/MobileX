package com.makeevrserg.mobilex.rsocket.encoding

import okio.ByteString

interface PlatformEncoder {
    fun toByteString(string: String): ByteString
    fun toByteArray(string: String): ByteArray
    fun fromByteString(byteString: ByteString): String
    fun fromByteArray(byteString: ByteArray): String
}