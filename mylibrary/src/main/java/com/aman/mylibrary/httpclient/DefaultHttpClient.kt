package com.aman.mylibrary.httpclient

import com.aman.mylibrary.internal.DownloadRequest

class DefaultHttpClient : HttpClient {
    override fun connect(req: DownloadRequest) {
        /*

    val range: String = String.format(
        Locale.ENGLISH, "bytes=%d-", req.downloadedBytes
    )

    val connection = URL(req.url).openConnection()

    connection.apply {
        readTimeout = req.readTimeOut
        connectTimeout = req.connectTimeOut
        addRequestProperty(Constants.RANGE, range)
    }

    connection.connect()

    */
    }

}