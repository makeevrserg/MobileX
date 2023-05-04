package com.makeevrserg.mobilex.core.domain

/**
 * UseCase from CleanArchitecture
 */
interface UseCase<out Type, in Params> {
    suspend fun run(params: Params): Type
    suspend operator fun invoke(params: Params) = run(params)
}
