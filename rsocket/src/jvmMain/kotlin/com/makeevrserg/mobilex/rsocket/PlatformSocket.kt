package com.makeevrserg.mobilex.rsocket

import com.makeevrserg.mobilex.rsocket.encoding.PlatformEncoder
import kotlinx.coroutines.flow.MutableStateFlow
import okhttp3.*
import okio.ByteString
import java.time.Duration

actual class PlatformSocket actual constructor(
    private val configuration: SocketConfiguration,
    private val rawSocketListener: RawSocketListener,
    private val encoder: PlatformEncoder
) : RawSocket, WebSocketListener() {

    override val isSocketOpening: MutableStateFlow<Boolean> = MutableStateFlow(false)
    override val isSocketOpen: MutableStateFlow<Boolean> = MutableStateFlow(false)

    private fun Long.toDuration() = Duration.ofMillis(this)

    private var okHttpClient: OkHttpClient = buildOkHttpClient()

    private var webSocket: WebSocket? = null
    private fun buildOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(configuration.connectTimeout.toDuration())
            .writeTimeout(configuration.writeTimeout.toDuration())
            .readTimeout(configuration.readTimeout.toDuration())
            .build()
    }

    private fun buildRequest(): Request {
        return Request.Builder()
            .url(configuration.url).apply {
                configuration.headers.forEach {
                    this.addHeader(it.key, it.value)
                }
            }
            .build()
    }

    override fun open() {
        if (isSocketOpening.value) return
        if (isSocketOpen.value) return
        isSocketOpening.value = true
        isSocketOpen.value = false
        okHttpClient.newWebSocket(buildRequest(), this)
    }

    override fun close() {
        webSocket?.close(0, "ZERO_CODE")
    }

    override fun sendMessage(message: SocketMessage<*, *>) {
        webSocket?.let {
            webSocket?.send(message.toJson())
        } ?: throw IllegalStateException("Socket is closed")
    }

    override fun sendByteMessage(message: SocketMessage<*, *>) {
        webSocket?.let {
            val byteString = message.toJson().let(encoder::toByteString)
            it.send(byteString)
        } ?: throw IllegalStateException("Socket is closed")
    }

    override fun onMessage(webSocket: WebSocket, text: String) {
        super.onMessage(webSocket, text)
        rawSocketListener.onMessage(text)

    }

    override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
        super.onMessage(webSocket, bytes)
        val json = encoder.fromByteString(bytes)
        rawSocketListener.onMessage(json)
    }

    override fun onOpen(webSocket: WebSocket, response: Response) {
        super.onOpen(webSocket, response)
        isSocketOpening.value = false
        isSocketOpen.value = true
        this.webSocket = webSocket
        rawSocketListener.onOpen()
    }


    override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
        super.onClosed(webSocket, code, reason)
        isSocketOpening.value = false
        isSocketOpen.value = false
        rawSocketListener.onClosed()
    }

    override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
        super.onFailure(webSocket, t, response)
        isSocketOpening.value = false
        isSocketOpen.value = false
        rawSocketListener.onFailure(t)
    }
}
