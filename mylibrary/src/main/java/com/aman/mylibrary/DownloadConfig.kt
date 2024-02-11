package com.aman.mylibrary

import com.aman.mylibrary.httpclient.DefaultHttpClient
import com.aman.mylibrary.httpclient.HttpClient

data class DownloadConfig (
    val httpClient: HttpClient = DefaultHttpClient(),
    val connectTimeOut : Int = Constants.DEFAULT_CONNECT_TIMEOUT_MILLS,
    val readTimeOut: Int = Constants.DEFAULT_READ_TIMEOUT_MILLS


)