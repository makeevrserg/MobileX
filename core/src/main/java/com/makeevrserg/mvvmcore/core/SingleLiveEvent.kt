package com.makeevrserg.mvvmcore.core

/**
 * Конвертирует объект в SingleLiveEvent - чтобы не обертывать его в класс
 */
fun <T> T.singleLiveEvent() = SingleLiveEvent(this)

/**
 * Класс необходим для реализации единоразового эвента, который должен быть собран единожды
 * Сообщение, роутинг
 */
class SingleLiveEvent<T>() {
    var value: T? = null
        private set
        get() {
            val value = field
            this.value = null
            return value
        }

    constructor(value: T) : this() {
        this.value = value
    }
}