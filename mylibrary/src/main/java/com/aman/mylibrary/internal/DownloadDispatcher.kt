package com.aman.mylibrary.internal

import com.aman.mylibrary.httpclient.HttpClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class DownloadDispatcher(private val httpClient: HttpClient) {
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    fun enqueue(req: DownloadRequest): Int {
        val job = scope.launch {
            execute(req)
        }
        req.job = job
        return req.downloadId
    }
    private suspend fun execute(request: DownloadRequest) {
        DownloadTask(request,httpClient).run (
            onStart = {
                executeOnMainThread { request.onStart() }
            },
            onProgress = {
                executeOnMainThread { request.onProgress(it) }
            },
            onComplete = {
                executeOnMainThread { request.onCompleted() }
            },
            onError = {
                executeOnMainThread { request.onError(it) }
            }
        )
    }
    private fun executeOnMainThread(block: () -> Unit){
        scope.launch {
            block()
        }
    }
    fun cancel(request: DownloadRequest) {
        request.job.cancel()
    }
//    fun pause(request: DownloadRequest){
//        request.downloadProgress
//    }
    fun cancellAll() {
        scope.cancel()
    }

}