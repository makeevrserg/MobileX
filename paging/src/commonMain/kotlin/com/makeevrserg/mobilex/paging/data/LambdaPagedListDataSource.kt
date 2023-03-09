package com.makeevrserg.mobilex.paging.data

import com.makeevrserg.mobilex.paging.state.PagingState

/**
 * This will allows you to use lambda data source
 */
class LambdaPagedListDataSource<T, K : Any>(
    private val loadPageLambda: suspend (PagingState<K>) -> List<T>?
) : PagedListDataSource<T, K> {
    override suspend fun getList(pagingState: PagingState<K>): List<T>? {
        return loadPageLambda(pagingState)
    }
}