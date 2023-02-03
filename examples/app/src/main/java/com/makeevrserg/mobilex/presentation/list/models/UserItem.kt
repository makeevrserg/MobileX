package com.makeevrserg.mobilex.presentation.list.models

import com.makeevrserg.mobilex.ktx_core.Randomization
import kotlin.random.Random

data class UserItem(
    val id: Int = Random.nextInt(),
    val name: String = Randomization.randomize(),
    val lastName: String = Randomization.randomize(),
    val userType: UserType=UserType.values().random()
) {
    enum class UserType {
        HUMAN, ROBOT, UNDEFINED
    }
}