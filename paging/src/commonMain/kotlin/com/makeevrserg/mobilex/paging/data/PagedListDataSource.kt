package com.makeevrserg.mobilex.paging.data

import com.makeevrserg.mobilex.paging.state.PagingState

/**
 * Default paged list interface
 */
interface PagedListDataSource<T, K : Any> {
    suspend fun getList(pagingState: PagingState<K>): List<T>?
}