package com.aman.mylibrary.internal

import com.aman.mylibrary.utils.getUniqueId
import kotlinx.coroutines.Job

class DownloadRequest private constructor(
    internal val url: String?,
    internal val tag: String?,
    internal val dirPath: String,
    internal val downloadId: Int,
    internal val fileName: String,
    internal val readTimeOut: Int,
    internal val connectTimeOut: Int
){
    internal val totalBytes: Long =0
    internal val downloadedBytes: Long =0
    internal var downloadProgress: Int = 0
     var isDownloadPause: Boolean = false         // used for to check Resume button click event,  not making it internal becuase wanted it to access form MainActivity
    internal lateinit var job: Job
    internal lateinit var onStart: () -> Unit
    internal lateinit var onProgress: (value: Int) -> Unit
    internal lateinit var onPause: () -> Unit
    internal lateinit var onCompleted: () -> Unit
    internal lateinit var onError: (error: String) -> Unit


    data class Builder(
        private val url: String,
        private val dirPath: String,
        private val fileName: String
    ){
        private var tag: String? = null
        private var readTimeOut: Int =0
        private var connectTimeOut : Int =0

        fun tag(tag: String): Builder{
            this.tag = tag
            return this
        }
        fun readTimeOut(timeOut:Int) = apply { // apply is returning the Builder Obj
            this.tag = tag
        }
        fun connectTimeout(timeOut: Int) = apply {
            this.connectTimeOut = timeOut
        }
        fun build(): DownloadRequest{
            return DownloadRequest(
             url = url,
                tag = tag,
                dirPath = dirPath,
                downloadId = getUniqueId(url, dirPath, fileName),
                fileName = fileName,
                readTimeOut = readTimeOut,
                connectTimeOut = connectTimeOut
                )
        }
    }
}