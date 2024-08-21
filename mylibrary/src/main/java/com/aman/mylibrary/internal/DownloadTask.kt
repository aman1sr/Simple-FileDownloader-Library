package com.aman.mylibrary.internal

import com.aman.mylibrary.httpclient.HttpClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class DownloadTask(private val req: DownloadRequest, private val httpClient: HttpClient) {

    suspend fun run(
        onStart: () -> Unit = {},
        onProgress: (value: Int) -> Unit = { _ -> },
        onPause: () -> Unit = {},
        onComplete: () -> Unit = {},
        onError: (error: String) -> Unit = { _ -> }
    ){
        withContext(Dispatchers.IO){
            // dummy code for downloading file

            httpClient.connect(req)
            val downloadStartByte = req.downloadProgress

            if(downloadStartByte == 0)
                onStart.invoke()

            for (i in downloadStartByte..100) {
                delay(1000)
                onProgress(i)
                req.downloadProgress  = i
            }
            onComplete.invoke()
        }

    }

}