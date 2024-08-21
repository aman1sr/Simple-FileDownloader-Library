# Simple File Downloader Library
A Sample Low Level Design of a file downloader library for Android with pause and resume support, following best pratices.

<p align="center">
<img alt="mvvm-architecture"  src="https://github.com/aman1sr/Simple-FileDownloader-Library/blob/master/app/screenshot/fileDownloader.png?raw=true">
</p>

### Major Highlights:
- Low Level Design of a File Downloader library having component like Download Request Builder, Request queue, Download Dispatcher , HttpClient and Download Task making Library higly customizable.
-This downloader library has a simple interface to make download request.
- We can check if the status of downloading with the given download Id.
- The Library gives callbacks for everything like onProgress, onCancel, onStart, onError and etc while downloading a file.
- Supports proper request canceling
- Supports pause and resume while downloading a file.
- Supports Custom HttpClient for a Download Request.
- Followed best pratices 
  - Builder Pattern:used to create Download Request Obj with few parameter compulsory & few are optional
  - Factory pattern:  used to create Downloader obj
  - use of interface: to pass differrent implementation of future usecase scenarios

## The Complete Library Folder Structure
```
├── Downloader
├── DownloadConfig
├── Downloader
├── httpclient
│   ├── DefaultHttpClient
│   ├── HttpClient
├── internals
│   ├── DownloadDispatcher
│   ├── DownloadRequest
│   ├── DownloadRequestQueue
│   └── DownloadTask
├── utils
│   ├── Utils


```

<p align="center">
<img alt="main_screen" src="https://github.com/aman1sr/Simple-FileDownloader-Library/blob/master/app/screenshot/1.jpeg?raw=true" width="360"  height="640"> &nbsp;&nbsp;&nbsp;&nbsp;
<img alt="top-top_headline" src="https://github.com/aman1sr/Simple-FileDownloader-Library/blob/master/app/screenshot/2.jpeg?raw=true" width="360"  height="640" marginLeft="20">
</p>

<p align="center">
<img alt="search1.1" src="https://github.com/aman1sr/Simple-FileDownloader-Library/blob/master/app/screenshot/3.jpeg?raw=true" width="360"  height="640"  marginLeft="20">
<img alt="search2" src="https://github.com/aman1sr/Simple-FileDownloader-Library/blob/master/app/screenshot/4.jpeg?raw=true" width="360"  height="640"  marginLeft="20">

</p>


