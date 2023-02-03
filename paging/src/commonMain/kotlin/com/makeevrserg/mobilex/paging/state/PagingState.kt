package com.makeevrserg.mobilex.paging.state

interface PagingState<T : Any> {
    val page: T
    val isLastPage: Boolean
    val isLoading: Boolean
    fun getNextPage(): T

    fun copyPagingState(
        page: T = this.page,
        isLastPage: Boolean = this.isLastPage,
        isLoading: Boolean = this.isLoading
    ): PagingState<T>
}