package com.makeevrserg.mobilex.paging

import com.makeevrserg.mobilex.paging.data.PagedListDataSource
import com.makeevrserg.mobilex.paging.state.PagingState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.updateAndGet


class PagingCollector<T, K : Any>(
    parentScope: CoroutineScope,
    private val initialPagingState: PagingState<K>,
    private val pager: PagedListDataSource<T, K>,
) {
    var pagingStateFlow: MutableStateFlow<PagingState<K>> = MutableStateFlow(initialPagingState)

    val list = MutableStateFlow<List<T>>(emptyList())
    fun reset() {
        list.value = emptyList()
        pagingStateFlow.value = initialPagingState
    }

    suspend fun loadNextPage() {
        var currentPagingState = pagingStateFlow.value.run {
            if (isLastPage) return
            if (isLoading) return
            pagingStateFlow.updateAndGet { copyPagingState(isLoading = true) }
        }
        val nextList = pager.getList(currentPagingState)
        if (!nextList.isNullOrEmpty())
            currentPagingState = currentPagingState.copyPagingState(page = currentPagingState.getNextPage())
        if (nextList != null && nextList.isEmpty())
            currentPagingState = currentPagingState.copyPagingState(isLastPage = true)
        list.update {
            it.toMutableList().apply {
                nextList?.let(::addAll)
            }
        }
        pagingStateFlow.update {
            currentPagingState.copyPagingState(isLoading = false)
        }
    }
}