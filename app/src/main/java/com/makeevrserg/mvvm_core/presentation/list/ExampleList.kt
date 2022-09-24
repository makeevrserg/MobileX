package com.makeevrserg.mvvm_core.presentation.list

import com.makeevrserg.mvvmcore.core.adapter.IDiffItem
import com.makeevrserg.mvvmcore.core.randomization.Randomization
import kotlin.random.Random

sealed interface ExampleList : IDiffItem<Int, ExampleList> {

    data class Header(
        override val id: Int = Randomization.randomize(),
        val message: String = Randomization.randomize()
    ) : ExampleList {

        override val instance: ExampleList
            get() = this

        override fun isEquals(newItem: IDiffItem<Int, ExampleList>): Boolean = this == instance


    }

    data class Item(
        override val id: Int = Randomization.randomize(),
        val groupItem: Int = Random.nextInt(20),
        val title: String = Randomization.randomize(),
        val description: String = Randomization.randomize()
    ) :
        ExampleList {

        override val instance: ExampleList
            get() = this

        override fun isEquals(newItem: IDiffItem<Int, ExampleList>): Boolean = this == instance

    }
}