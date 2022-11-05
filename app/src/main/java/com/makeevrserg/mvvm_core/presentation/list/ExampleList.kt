package com.makeevrserg.mvvm_core.presentation.list

import com.makeevrserg.mvvmcore.core.adapter.IDiffItem
import com.makeevrserg.mvvm_core.ktx_core.Randomization
import kotlin.random.Random

sealed interface ExampleList : IDiffItem<Int, ExampleList> {

    data class Header(
        override val id: Int = com.makeevrserg.mvvm_core.ktx_core.Randomization.randomize(),
        val message: String = com.makeevrserg.mvvm_core.ktx_core.Randomization.randomize()
    ) : ExampleList {

        override val instance: ExampleList
            get() = this

        override fun isEquals(newItem: IDiffItem<Int, ExampleList>): Boolean = this == instance


    }

    data class Item(
        override val id: Int = com.makeevrserg.mvvm_core.ktx_core.Randomization.randomize(),
        val groupItem: Int = Random.nextInt(20),
        val title: String = com.makeevrserg.mvvm_core.ktx_core.Randomization.randomize(),
        val description: String = com.makeevrserg.mvvm_core.ktx_core.Randomization.randomize()
    ) :
        ExampleList {

        override val instance: ExampleList
            get() = this

        override fun isEquals(newItem: IDiffItem<Int, ExampleList>): Boolean = this == instance

    }
}