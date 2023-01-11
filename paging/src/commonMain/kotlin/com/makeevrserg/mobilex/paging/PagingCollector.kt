package com.makeevrserg.mobilex.paging

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update


class PagingCollector<T>(
    private val initialPage: Int,
    private val pager: IPager<T>,
    private val onListUpdated: (List<T>) -> Unit = {},
) {
    private var pagingState = PagingState(
        initialPage,
        false
    )
    private var isLoading: Boolean = false
    val list = MutableStateFlow<List<T>>(emptyList())
    fun reset() {
        list.value = emptyList()
        pagingState.isLastPage = false
        isLoading = false
        pagingState.page = initialPage
    }

    suspend fun loadNextPage() {
        if (pagingState.isLastPage) return
        if (isLoading) return
        isLoading = true
        val nextList = pager.getList(pagingState)
        if (!nextList.isNullOrEmpty())
            pagingState.page += 1
        if (nextList != null && nextList.isEmpty())
            pagingState.isLastPage = true
        list.update {
            it.toMutableList().apply {
                nextList?.let(::addAll)
            }
        }
        onListUpdated(list.value)
        isLoading = false
    }
}