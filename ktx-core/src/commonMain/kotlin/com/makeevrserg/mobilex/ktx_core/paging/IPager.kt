package com.makeevrserg.mobilex.ktx_core.paging

interface IPager<T> {
    suspend fun getList(pagingState: PagingState): List<T>?
}