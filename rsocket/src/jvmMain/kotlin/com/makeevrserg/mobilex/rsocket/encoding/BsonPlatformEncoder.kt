package com.makeevrserg.mobilex.rsocket.encoding

import com.mongodb.BasicDBObject
import okio.ByteString
import okio.ByteString.Companion.toByteString
import org.bson.BasicBSONEncoder
import org.bson.RawBsonDocument
import org.bson.json.JsonWriterSettings

class BsonPlatformEncoder : PlatformEncoder {
    private val settings = JsonWriterSettings.builder().build()
    override fun toByteString(string: String): ByteString {
        return toByteArray(string).toByteString()
    }

    override fun toByteArray(string: String): ByteArray {
        return BasicBSONEncoder().encode(BasicDBObject.parse(string))
    }

    override fun fromByteString(byteString: ByteString): String {
        return fromByteArray(byteString.toByteArray())
    }

    override fun fromByteArray(byteString: ByteArray): String {
        return RawBsonDocument(byteString).toJson(settings)
    }
}