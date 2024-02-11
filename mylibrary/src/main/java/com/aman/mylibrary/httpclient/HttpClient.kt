package com.aman.mylibrary.httpclient

import com.aman.mylibrary.internal.DownloadRequest

interface HttpClient {
    fun connect (req: DownloadRequest)
}