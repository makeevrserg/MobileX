package com.makeevrserg.mvvm_core.ktx_core.architecture

interface IUseCase<out Type, in Params> {
    abstract suspend fun run(params: Params): Type
    suspend operator fun invoke(params: Params) = run(params)

}