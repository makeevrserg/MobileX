[Overview](index.md) | [ktx-core](ktx-core.MD) | [di](di.MD)

## KTX-Core

KTX-core includes cored dependencies which may help yo reduce boilerplate

## UseCase
UseCase have come from CleanArchitecture and it's included here
```kotlin
class MyUseCase(private val api: Api) : UseCase<String, MyUseCase.Param> {
    class Param(val id: Int)

    override suspend fun run(params: Param): String {
        return api.callServer(params)
    }
}
```
## Mapper
Mapper is used to map classes from DTO into server models and vice-versa
```kotlin
class User(val name: String, val fullName: String)

class UserDTO(val fullName: String)

class UserMapper : Mapper<User, UserDTO> {
    override fun toDTO(it: User): UserDTO {
        return UserDTO("${it.name} ${it.fullName}")
    }

    override fun fromDTO(it: UserDTO): User {
        val (name, fullName) = it.fullName.split(" ")
        return User(name, fullName)
    }
}
```
## KotlinDispatchers
So Swift doesn't have IO dispatchers, but still wanna use it? This may be for you.

This is an Interface, so you can use it for tests
```kotlin
object MockDispatchers: KotlinDispatchers {
    override val Main: CoroutineDispatcher = Dispatchers.Main
    override val IO: CoroutineDispatcher = Dispatchers.Main
    override val Default: CoroutineDispatcher = Dispatchers.Main
    override val Unconfined: CoroutineDispatcher = Dispatchers.Main
}
```
You can use it in your viewModels:

```kotlin
class MyViewModel(
    private val dispatchers: KotlinDispatchers = KDispatchers
) {
    init {
        viewModelScope.launch(dispatchers.IO) {
            // some job
        }
    }
}
```

## Storage
If you want to use storage values without depending on library - this is for you

In this example StringStorageValue is depending on SharedPreferences, but myTokenStorageValue is FlowStorageValue
```kotlin
class StringStorageValue(
    sharedPreferences: SharedPreferences,
    key: String,
    default: String,
) : FlowStorageValue<String> by DefaultFlowStorageValue<String>(
    default = default,
    loadSettingsValue = {
        sharedPreferences.getString(key, default) ?: default
    },
    saveSettingsValue = {
        sharedPreferences.edit().putString(key, it).apply()
    }
)

val myTokenStorageValue: FlowStorageValue<String> = StringStorageValue(prefs,"my_token","")
```

FlowStorageValue is inerhited from StorageValue, so if you don't want flow reactivity - you can create it with default StorageValue

## Enums
There's also some useful enum extension:
```kotlin
enum class MyEnum{
    FIRST,SECOND
}
fun nextEnum(enum: MyEnum){
    val secondEnum: MyEnum = enum.next()
    val firstEnum: MyEnum = secondEnum.next()
}
```

## SealedExceptionHandler
```kotlin
fun catchSealed() {
    val handler = SealedExceptionHandler<SealedException> {
        when (it) {
            SealedException.First -> TODO()
            SealedException.Second -> TODO()
        }
    }
    runCatching {
        throw SealedException.First
    }.onSealedFailure { exception: SealedException ->
        // make noise
    }
}
```
## Android-Specific
```kotlin
// This function will make your phone vibrating
fun vibrate(context: Context) {
    context.vibratePhone(100L)
}
// You can also check for permissions
fun hasInternalAndWifi(context: Context): Boolean {
    return context.hasPermissions(Manifest.permission.INTERNET,Manifest.permission.ACCESS_WIFI_STATE)
}
```
