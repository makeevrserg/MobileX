package com.makeevrserg.mobilex.paging.state

data class DefaultPagingState<T : Any>(
    override val page: T,
    override val isLastPage: Boolean,
    override val isLoading: Boolean,
    private val getNextPage: DefaultPagingState<T>.() -> T
) : PagingState<T> {
    override fun getNextPage(): T {
        return getNextPage.invoke(this)
    }

    override fun copyPagingState(page: T, isLastPage: Boolean, isLoading: Boolean): PagingState<T> {
        return this.copy(
            page = page,
            isLastPage = isLastPage,
            isLoading = isLoading
        )
    }
}