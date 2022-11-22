package com.makeevrserg.mobilex.ktx_core.domain

/**
 * Basic mapper for DTO objects
 */
interface IMapper<I, O> {
    fun toDTO(it: I): O
    fun fromDTO(it: O): I
}
