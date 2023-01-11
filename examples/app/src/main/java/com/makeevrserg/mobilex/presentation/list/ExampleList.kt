package com.makeevrserg.mobilex.presentation.list

import com.makeevrserg.mobilex.ktx_core.Randomization
import com.makeevrserg.mobilex.rvadapter.IDiffItem
import kotlin.random.Random

sealed class ExampleList : IDiffItem<Int, ExampleList> {
    override val instance: ExampleList
        get() = this
    override fun isEquals(newItem: IDiffItem<Int, ExampleList>): Boolean = this == newItem.instance

    data class Header(
        override val id: Int = Randomization.randomize(),
        val message: String = Randomization.randomize()
    ) : ExampleList()

    data class Item(
        override val id: Int = Randomization.randomize(),
        val groupItem: Int = Random.nextInt(20),
        val title: String = Randomization.randomize(),
        val description: String = Randomization.randomize()
    ) : ExampleList()
}