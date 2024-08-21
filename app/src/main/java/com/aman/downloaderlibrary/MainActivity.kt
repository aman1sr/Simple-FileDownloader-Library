package com.aman.downloaderlibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.aman.downloaderlibrary.databinding.ActivityMainBinding
import com.aman.mylibrary.Downloader

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       val downloader = (applicationContext as MyApplication).downloader
        if(downloader != null) Toast.makeText(this, "downoader obj created", Toast.LENGTH_SHORT).show()

        val request = downloader.newReqBuilder("someUrl",
            "someDirPath",
            "someFileName")
            .readTimeOut(10000)
            .connectTimeout(10000)
            .tag("someTag")
            .build()            // created a DownloadRequest obj

        downloader.enqueue(request,
            onStart = {
                binding.textView.text = "onStart"
                binding.progressBar.visibility = View.VISIBLE
            },
            onProgress = {
                binding.txtProgress.text = "progress: ${it.toString()} %"
            },
            onPause = {
                binding.textView.text = "onPause"
            },
            onComplete = {
                binding.textView.text = "onCompleted"
                binding.progressBar.visibility = View.GONE
            },
            onError = {
                binding.textView.text = it
            }
            )


    }
}