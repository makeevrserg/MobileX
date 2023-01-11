package com.makeevrserg.mobilex.paging

interface IPager<T> {
    suspend fun getList(pagingState: PagingState): List<T>?
}