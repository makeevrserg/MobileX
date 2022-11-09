package com.makeevrserg.mobilex.core_compose

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.makeevrserg.mobilex.core.PagingCollector
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


fun LazyListState.isScrolledToTheEnd(): Boolean {
    val lastVisibleIndex = layoutInfo.visibleItemsInfo.lastOrNull()?.index
    val totalItems = layoutInfo.totalItemsCount - 1
    return lastVisibleIndex == totalItems || lastVisibleIndex == null || totalItems == 0
}

fun LazyGridState.isScrolledToTheEnd(): Boolean {
    val lastVisibleIndex = layoutInfo.visibleItemsInfo.lastOrNull()?.index
    val totalItems = layoutInfo.totalItemsCount - 1
    return lastVisibleIndex == totalItems || lastVisibleIndex == null || totalItems == 0
}


@Composable
fun <T> PagingCollector<T>.collect(state: LazyListState, key: Any = state) {
    if (state.isScrolledToTheEnd())
        LaunchedEffect(key1 = key) {
            withContext(Dispatchers.IO) {
                loadNextPage()
            }
        }


}

@Composable
fun <T> PagingCollector<T>.collect(state: LazyGridState, key: Any = state) {
    if (state.isScrolledToTheEnd())
        LaunchedEffect(key1 = key) {
            withContext(Dispatchers.IO) {
                loadNextPage()
            }
        }
}