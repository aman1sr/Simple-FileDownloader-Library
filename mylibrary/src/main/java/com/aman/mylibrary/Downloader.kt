package com.aman.mylibrary

import com.aman.mylibrary.internal.DownloadDispatcher
import com.aman.mylibrary.internal.DownloadRequest
import com.aman.mylibrary.internal.DownloadRequestQueue

class Downloader private constructor(private val config: DownloadConfig){
    companion object{
       fun create(config: DownloadConfig = DownloadConfig()): Downloader{
           return Downloader(config)
       }
    }

    private val reqQueue = DownloadRequestQueue(DownloadDispatcher(config.httpClient))

    fun newReqBuilder(url: String, dirPath: String, fileName: String): DownloadRequest.Builder{
        return DownloadRequest.Builder(url, dirPath, fileName).readTimeOut(config.readTimeOut).connectTimeout(config.connectTimeOut)
    }

    fun enqueue(
        req: DownloadRequest,
        onStart: () -> Unit = {},
        onProgress: (value: Int) -> Unit = { _ -> },
        onPause: () -> Unit = {},
        onComplete: () -> Unit = {},
        onError : (error: String) -> Unit = { _ -> }
    ): Int{
        req.onStart = onStart
        req.onProgress = onProgress
        req.onPause = onPause
        req.onCompleted = onComplete
        req.onError = onError

        return reqQueue.enqueue(req)
    }
    fun pause(id: Int) {
        reqQueue.pause(id)
    }
       fun resume(id: Int) {
        reqQueue.resume(id)
    }
    fun cancel(id: Int) {
        reqQueue.cancel(id)
    }

 fun cancel(tag: String) {
        reqQueue.cancel(tag)
    }
    fun cancelAll() {
        reqQueue.cancelAll()
    }

}