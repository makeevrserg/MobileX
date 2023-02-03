package com.makeevrserg.mobilex.presentation.list.adapters.sealed

import com.makeevrserg.mobilex.databinding.ItemUserBinding
import com.makeevrserg.mobilex.presentation.list.models.SealedUser
import com.makeevrserg.mobilex.rvadapter.sealed.SealedViewHolder


class UserItemViewHolder : SealedViewHolder<SealedUser, SealedUser.User, ItemUserBinding>(
    SealedUser.User::class.java,
    ItemUserBinding::inflate
) {
    override val viewType: Int = 0

    override fun bind(binding: ItemUserBinding, item: SealedUser.User) {
        binding.tvName.text = item.user.name
        binding.tvLastName.text = item.user.lastName
        binding.tvType.text = item.user.userType.name
    }
}