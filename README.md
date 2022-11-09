
[![jitpack](https://img.shields.io/jitpack/version/com.github.makeevrserg/AndroidEssentials?style=for-the-badge)](https://github.com/makeevrserg/AndroidEssentials/releases)

# MVVM-core
MVVM core is a library which I'm using in my projects - it helps to reduce boiler-plate code a lot

## Setup

Add required modules to your module`s build.gradle file:
```groovy
implementation 'com.github.makeevrserg:AndroidEssentials:<version>'
```

Add jitpack
```groovy
repositories {
  maven { url 'https://jitpack.io' }
}
```

And of course, it breaks some of MVVM rules:
- You are controlling navigation from ViewModel by using RouteInfo
- You are making dialogs interfaces in ViewModel using UIDialogMessage
- You send messages to Fragment by UiText

mobilex allows:

- [x] - Controlling navigation from ViewModel using RouteInfo
- [x] - Show loading indicator which is blocking user interaction
- [x] - Creating Dialogs and manage it's onPositive/Negative clicked
- [x] - Creating Toasts and Snackbars
- [x] - Improved UiText originally seen from Philipp Lackner
- [x] - SingleLiveEvent which is used a lot
- [x] - Loading state: Loading/Loaded/Error
- [x] - Helpful extensions like Flow.collectOn; lazyViewModel; Serializable bundle
- [x] - Base UseCase abstract class with return Type and input Params
- [x] - Core Binding Fragment and CoreViewModel
- [x] - Almost Everything is configurable - you can create own dialogs, progress dialogs or event intent manager. CoreBindingFragment contains only interfaces

TODO:

- [ ] - Logger implementation which supports android > 28 saving strategy

