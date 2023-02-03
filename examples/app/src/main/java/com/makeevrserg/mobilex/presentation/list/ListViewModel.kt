package com.makeevrserg.mobilex.presentation.list

import androidx.lifecycle.ViewModel
import com.makeevrserg.mobilex.ktx_core.Randomization
import com.makeevrserg.mobilex.presentation.list.models.SealedUser
import com.makeevrserg.mobilex.presentation.list.models.UserItem
import kotlin.random.Random
import kotlin.random.nextInt

class ListViewModel : ViewModel() {
    val RandomUserItem: UserItem
        get() = UserItem()

    val list = Randomization.ofList(100) {
        RandomUserItem
    }
    val sealedList = Randomization.ofList(100) {
        RandomUserItem
    }.groupBy { it.userType }.flatMap { (type, list) ->
        buildList<SealedUser> {
            add(SealedUser.Header(type))
            addAll(list.map { SealedUser.User(it) })
        }
    }
}