package com.aman.downloaderlibrary

import android.app.Application
import com.aman.mylibrary.Downloader

class MyApplication : Application(){
    lateinit var downloader: Downloader

    override fun onCreate() {
        super.onCreate()
        downloader = Downloader.create()
    }
}