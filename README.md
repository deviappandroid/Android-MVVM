
## About
 
  It is a demo project for demonstration of mvvm structure using kotlin-first

- Best practices suggested by google. 
- CSV parser for read and write
- List of VPN (Virtual Private Networks) Servers

## Built With 🛠
- [Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development.
- Clean Architecture
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - For asynchronous and more..
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
    - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes.
    - [ViewBinding](https://developer.android.com/topic/libraries/view-binding) - Generates a binding class for each XML layout file present in that module and allows you to more easily write code that interacts with views.
    - [DataBinding](https://developer.android.com/topic/libraries/data-binding) - Binds data directly into XML layouts
- [Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java.
- [GSON](https://github.com/google/gson) - A modern JSON library for Kotlin and Java.
- [Material Components for Android](https://github.com/material-components/material-components-android) - Modular and customizable Material Design UI components for Android.

# Multi Module Package Structure

    **app module**
    
    com.iapp.androidmvvm   # app Root Package
    ├── api                 # Api GET resquest header and relative info
    ├── datasource          # For data handling
    ├── model               # Model data classes mapped from api model classes
    ├── network             # Api and Client Files
    ├── respo               # Repository Files 
    ├── ui                  # UI/View layer
    │ └── adapters          # All Adapters 
    │ └── Server            # Server Activity
    └── utils                # Utility Classes / Kotlin extensions / Constants/ diffUtils for recyclerViews
    └── viewmodel          # Vewholder Classes 


## Architecture
This app uses [***MVVM (Model View View-Model)***](https://developer.android.com/jetpack/docs/guide#recommended-app-arch) architecture.

![](https://developer.android.com/topic/libraries/architecture/images/final-architecture.png)

## Contact
If you need any help, you can connect with Iapp Technologies LLP.
