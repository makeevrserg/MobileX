package com.makeevrserg.mobilex.core

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class PagingCollector<T>(
    private val initialPage: Int,
    val coroutineScope: CoroutineScope,
    private val onUpdated: (List<T>) -> Unit,
    private val loader: suspend ( page: Int) -> List<T>?
) {
    var page = initialPage - 1
    private var isLastPage: Boolean = false
    private var isLoading: Boolean = false
    val list = MutableStateFlow<List<T>>(emptyList())
    suspend fun reset() {
        list.value = emptyList()
        isLastPage = false
        isLoading = false
        page = initialPage - 1
    }

    suspend fun loadNextPage() {
        if (isLastPage) return
        if (isLoading) return
        isLoading = true
        val nextPage = page + 1
        val nextList = loader(nextPage)
        if (!nextList.isNullOrEmpty())
            page = nextPage
        if (nextList != null && nextList.isEmpty())
            isLastPage = true
        list.update {
            it.toMutableList().apply {
                nextList?.let(::addAll)
            }
        }
        onUpdated(list.value)
        isLoading = false
    }
}