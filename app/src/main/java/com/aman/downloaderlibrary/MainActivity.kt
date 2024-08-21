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

val downloadID =     downloader.enqueue(request,
            onStart = {
                binding.progressBar.visibility = View.VISIBLE
            },
            onProgress = {
                binding.txtProgress.text = "progress: ${it.toString()} %"
            },
            onPause = {
                binding.textView.text = "onPause"
            },
            onComplete = {
                binding.textView.text = "Hurray!! Download Completed"
                binding.progressBar.visibility = View.GONE
            },
            onError = {
                binding.textView.text = it
            }
            )

        binding.btnPause.setOnClickListener {
            if (!request.isDownloadPause) {
                downloader.pause(downloadID)
                Toast.makeText(this, "Download Pause", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnResume.setOnClickListener {
            if (request.isDownloadPause) {
                downloader.resume(downloadID)
                Toast.makeText(this, "Download Resume", Toast.LENGTH_SHORT).show()
            }
        }


    }
}