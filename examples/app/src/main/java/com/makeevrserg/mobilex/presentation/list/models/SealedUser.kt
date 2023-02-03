package com.makeevrserg.mobilex.presentation.list.models

sealed class SealedUser {
    data class Header(
        val userType: UserItem.UserType
    ) : SealedUser()

    data class User(
        val user: UserItem
    ) : SealedUser()
}