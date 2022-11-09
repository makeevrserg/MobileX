package com.makeevrserg.mobilex.ktx_core.domain

interface IUseCase<out Type, in Params> {
    abstract suspend fun run(params: Params): Type
    suspend operator fun invoke(params: Params) = run(params)

}