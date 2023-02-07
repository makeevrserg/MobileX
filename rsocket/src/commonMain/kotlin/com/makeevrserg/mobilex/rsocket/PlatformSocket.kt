package com.makeevrserg.mobilex.rsocket

import com.makeevrserg.mobilex.rsocket.encoding.PlatformEncoder

expect class PlatformSocket(
    configuration: SocketConfiguration,
    rawSocketListener: RawSocketListener,
    encoder: PlatformEncoder
) : RawSocket