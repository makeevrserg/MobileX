[Overview](index.md) | [ktx-core](ktx-core.MD) | [di](di.MD)

## DI

DI is super lightweight manual dependency injection module.

You can easily create dependencies for your project without DI fraemwork.
All your submodules will contain module interfaces which will be implemented inside viewmodel and etc by delegation

## Simple module
```kotlin
/**
* Firstly, define a contract
**/
interface RootModule: Module {
    val settings: Single<Settings>
}
/**
* Secondly, create implementation
**/
object RootModuleImpl: RootModule {
    val settings = Single {
        CustoSettings()
    }
}
/**
* Next you can pass this module and implement it with delegation
*/
class MyViewModel(
    module: RootModule
): ViewModel(), RootModule by module {
    init {
        settings.loadSomeSettings()
    }
}
```

## Android context and platform-specific
It's obsious that some properties can't be initialized automatically and lazely, so here's Lateinit.
```kotlin
object SingletonModule: Module {
    val context = Lateinit<Context>
}
class MyApplication: Application {
    override fun onCreate() {
        super.onCreate()
        SingletonModule.context.initialize(applicationContext)
    }
}
```
Also some modules don't need to be singletons, so there's also Provider and Factory for you
```kotlin
class MyModule: Module {
    // Factory object can be created with .create() method
    val stringFactory = Factory {
        "Some string"
    }
    // Provider is just a wrapper and object can be accessed by delegation or .provide() method
    val customUseCase = Provider {
        val someString = stringFactory.create()
        CustomUseCase(someString)
    }
    // Provider, Single and Lateinit can be used with delegation
    val providedCustomUseCase by customUseCase
    // There's also top level interface
    // it's parent for Lateinit and Single
    // Delegation is avaliable 
    val intDependency: Dependency<Int> = Single { 10 }
}
```
If you have multiple modules, you have different ways to use it
```kotlin
object RootModule: Module
object ServicesModule: Module
// Either pass it into constructor
class CustomModule(
    private val rootModule: RootModule,
    private val servicesModule: ServicesModule
)
// Or use delegation
class CustomModule2 {
    private val rootModule by RootModule
    private val servicesModule by ServicesModule
}
```