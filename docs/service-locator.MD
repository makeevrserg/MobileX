## Service Locator

Service locator is super lightweight dependency container

With this, you can easily create dependencies for your project without DI fraemwork

Theres multiple ways to create service-locator

How modules can be created:
```kotlin
object MyStringModule : Module<String>() {
    override fun initializer(): String {
        return "Hello world Module!"
    }
}
object ServiceLocator {
    val myStringModule = module {
        "Hello world Module!"
    }
}
```
How Factories can be used:
```kotlin
object ServiceLocator{
    fun viewModelFactory(api: CustomApi) = factory{
        MyViewModel(api)
    }
}
```
You can also define other modules inside each others
```kotlin
object ServiceLocator {
    val myApi = modules {
        MyApi()
    }
    val viewModelFactory = factory {
        val api by myApi
        MyViewModel(api)
    }
}
```
### C-Interop
Of course there will be problems with Swift, but there's workaround
```kotlin
object ServiceLocator {
    val myApi = modules {
        MyApi()
    }.cDependency()
    
    val viewModelFactory = factory {
        val api by myApi
        MyViewModel(api)
    }.cDependency()
}
```

