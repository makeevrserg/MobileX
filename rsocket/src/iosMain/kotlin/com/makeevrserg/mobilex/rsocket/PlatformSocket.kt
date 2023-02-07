package com.makeevrserg.mobilex.rsocket

import com.makeevrserg.mobilex.rsocket.encoding.PlatformEncoder
import kotlinx.cinterop.*
import kotlinx.coroutines.flow.MutableStateFlow
import platform.Foundation.*
import platform.darwin.NSObject

actual class PlatformSocket actual constructor(
    private val configuration: SocketConfiguration,
    private val rawSocketListener: RawSocketListener,
    private val encoder: PlatformEncoder
) : RawSocket {

    private val socketEndpoint = NSURL.URLWithString(configuration.url)!!
    private var webSocket: NSURLSessionWebSocketTask? = null

    override val isSocketOpening: MutableStateFlow<Boolean> = MutableStateFlow(false)
    override val isSocketOpen: MutableStateFlow<Boolean> = MutableStateFlow(false)


    override fun open() {
        val urlSession = NSURLSession.sessionWithConfiguration(
            configuration = NSURLSessionConfiguration.defaultSessionConfiguration(),
            delegate = object : NSObject(), NSURLSessionWebSocketDelegateProtocol {
                override fun URLSession(
                    session: NSURLSession,
                    webSocketTask: NSURLSessionWebSocketTask,
                    didOpenWithProtocol: String?
                ) {
                    rawSocketListener.onOpen()
                }

                override fun URLSession(
                    session: NSURLSession,
                    webSocketTask: NSURLSessionWebSocketTask,
                    didCloseWithCode: NSURLSessionWebSocketCloseCode,
                    reason: NSData?
                ) {
                    rawSocketListener.onClosed()
                }
            },
            delegateQueue = NSOperationQueue.currentQueue()
        )
        webSocket = urlSession.webSocketTaskWithURL(socketEndpoint)
        listen()
        webSocket?.resume()
    }

    private fun listen() {
        webSocket?.receiveMessageWithCompletionHandler { message, nsError ->
            when {
                nsError != null -> rawSocketListener.onFailure(Throwable(nsError.description))
                message != null -> {
                    val string = message.data?.let { data ->
                        val length = data.length.toInt()
                        val bytes = data.bytes?.readBytes(length)
                        bytes?.let(encoder::fromByteArray)
                    } ?: message.string
                    string?.let(rawSocketListener::onMessage)
                }
            }
            listen()
        }
    }

    override fun close() {
        webSocket?.cancelWithCloseCode(0, null)
        webSocket = null
    }

    private fun sendNsMessage(message: NSURLSessionWebSocketMessage) {
        webSocket?.sendMessage(message) {} ?: throw IllegalStateException("Socket is closed")
    }

    override fun sendMessage(message: SocketMessage<*, *>) {
        val json = message.toJson()
        val nsMessage = NSURLSessionWebSocketMessage(json)
        sendNsMessage(nsMessage)
    }

    override fun sendByteMessage(message: SocketMessage<*, *>) = memScoped {
        val json = message.toJson()
        val byteArray = encoder.toByteArray(json)
        val nsData = NSData.create(
            bytesNoCopy = byteArray.toCValues().getPointer(this),
            length = byteArray.size.toULong()
        ).base64EncodedStringWithOptions(0)
        val nsMessage = NSURLSessionWebSocketMessage(nsData)
        sendNsMessage(nsMessage)
    }
}
