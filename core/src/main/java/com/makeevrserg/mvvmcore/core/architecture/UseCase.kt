package com.makeevrserg.mvvmcore.core.architecture

abstract class UseCase<out Type, in Params> {
    abstract suspend fun run(params: Params): Type
    suspend operator fun invoke(params: Params) = run(params)

}