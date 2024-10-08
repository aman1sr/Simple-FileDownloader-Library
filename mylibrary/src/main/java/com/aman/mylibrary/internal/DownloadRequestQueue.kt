package com.aman.mylibrary.internal

class DownloadRequestQueue(private val dispatcher: DownloadDispatcher) {
    private val idRequestMap: HashMap<Int, DownloadRequest> = hashMapOf()

    fun enqueue(request: DownloadRequest): Int {
        idRequestMap[request.downloadId] = request
        return dispatcher.enqueue(request)
    }
    fun start(id: Int){
        idRequestMap[id]?.let {
            it.isDownloadStart = true
            dispatcher.enqueue(it)
        }
    }
    fun pause(id: Int) {
        idRequestMap[id]?.let {
            it.isDownloadPause = true
            dispatcher.cancel(it)
            it.onPause.invoke()
        }
    }

    fun resume(id: Int) {
        idRequestMap[id]?.let {
            it.isDownloadPause = false
            dispatcher.enqueue(it)
            it.onResume.invoke()
        }
    }
    fun cancel(id: Int){
        idRequestMap[id]?.let {
            dispatcher.cancel(it)
            it.onCancel.invoke()
        }
        idRequestMap.remove(id)

    }
    fun cancel(tag: String) {
        val requuestWithTag = idRequestMap.values.filter {
            it.tag == tag
        }
        for (req in requuestWithTag) {
            cancel(req.downloadId)
        }
    }
    fun cancelAll() {
        idRequestMap.clear()
        dispatcher.cancellAll()
    }
}