package com.aman.mylibrary.internal

class DownloadRequestQueue(private val dispatcher: DownloadDispatcher) {
    private val idRequestMap: HashMap<Int, DownloadRequest> = hashMapOf()

    fun enqueue(request: DownloadRequest): Int {
        idRequestMap[request.downloadId] = request
        return dispatcher.enqueue(request)
    }
    fun pause(id: Int) {
        idRequestMap[id]?.let {
            it.isDownloadPause = true
            dispatcher.cancel(it)
        }
    }

    fun resume(id: Int) {
        idRequestMap[id]?.let {
            it.isDownloadPause = false
            dispatcher.enqueue(it)
        }
    }
    fun cancel(id: Int){
        idRequestMap[id]?.let {
            dispatcher.cancel(it)
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