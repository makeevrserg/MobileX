package com.makeevrserg.mobilex.paging.state

data class IntPagingState(
    override var page: Int,
    override var isLastPage: Boolean = false,
    override val isLoading: Boolean = false
) : PagingState<Int> {
    override fun getNextPage(): Int {
        return page + 1
    }

    override fun copyPagingState(
        page: Int,
        isLastPage: Boolean,
        isLoading: Boolean
    ): PagingState<Int> {
        return this.copy(
            page = page,
            isLastPage = isLastPage,
            isLoading = isLoading
        )
    }
}
