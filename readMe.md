# NewsApp-MVVM-Architecture
Introducing our cutting-edge News MVVM app, meticulously crafted with the latest technologies recommended by Google. This app is designed to deliver a seamless news reading experience, whether you're online or offline. Here’s a sneak peek into its features and architecture:

### Major Highlights:
- **MVVM Architecture** : Built using the Model-View-ViewModel architecture, ensuring a clean separation of concerns and making the app highly maintainable and testable.
- **Offline-First**: Prioritizes offline access with a single source of truth, ensuring you can read the news even without an internet connection.
- **Room Database**: Utilizes Room for efficient local data storage and retrieval.
- **Dependency Injection with Hilt**: Implements Hilt for managing dependencies, reducing boilerplate code and improving scalability.
- **Pagination Library**: Seamlessly handles data pagination, providing a smooth scrolling experience through endless news articles.
- **Coroutines and Flow API**: Leverages Kotlin Coroutines and Flow API for efficient and smooth data processing pipelines.
- **Comprehensive Unit Testing**: Ensures robustness with extensive unit tests covering all critical components.

## The Complete Project Folder Structure
```
├── NewsApplication.kt
├── data
│   ├── api
│   ├── local
│   ├── model
│   └── repository
├── di
│   ├── component
│   ├── module
│   ├── qualifiers.kt
│   └── scopes.kt
├── ui
│   ├── MainActivity.kt
│   ├── base
│   ├── country
│   ├── language
│   ├── newsListScreen
│   ├── pagination
│   ├── search
│   ├── sources
│   └── topheadline
└── utils
    ├── AppConstant.kt
    ├── DispatcherProvider.kt
    ├── Extentions.kt
    ├── NetworkHelper.kt
    ├── Resource.kt
    ├── Status.kt
    ├── TypeAliases.kt
    └── network

```

<p align="center">
    <div style="display: flex; justify-content: center;">
        <img alt="main_screen" src="https://github.com/aman1sr/NewsApp-MVVM-Architecture/blob/master/app/screenshot/newsHome.jpeg" width="360"  height="640"> &nbsp;&nbsp;&nbsp;&nbsp;
        <img alt="top-top_headline" src="https://github.com/aman1sr/NewsApp-MVVM-Architecture/blob/master/app/screenshot/newsTopHeadline.jpeg" width="360"  height="640">
    </div>
</p>
<p align="center">
    <div style="display: flex; justify-content: center;">
        <img alt="search1.1" src="https://github.com/aman1sr/NewsApp-MVVM-Architecture/blob/master/app/screenshot/newsSearch1.1.jpeg" width="360"  height="640"> &nbsp;&nbsp;&nbsp;&nbsp;
        <img alt="search2" src="https://github.com/aman1sr/NewsApp-MVVM-Architecture/blob/master/app/screenshot/newsSearch2.jpeg" width="360"  height="640"> &nbsp;&nbsp;&nbsp;&nbsp;
        <img alt="search2.2" src="https://github.com/aman1sr/NewsApp-MVVM-Architecture/blob/master/app/screenshot/newsSearch2.2.jpeg" width="360"  height="640">
    </div>
</p>


