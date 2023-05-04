package com.makeevrserg.mobilex.core.domain

/**
 * Basic mapper for DTO objects
 */
interface Mapper<T, DTO> {
    fun toDTO(it: T): DTO
    fun fromDTO(it: DTO): T
}
