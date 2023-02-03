package com.makeevrserg.mobilex.presentation.list.adapters

import com.makeevrserg.mobilex.databinding.ItemUserBinding
import com.makeevrserg.mobilex.presentation.list.models.UserItem
import com.makeevrserg.mobilex.rvadapter.single.DefaultViewBinder

class SingleUserItemViewHolder : DefaultViewBinder<UserItem, ItemUserBinding>(ItemUserBinding::inflate) {
    override fun bind(binding: ItemUserBinding, item: UserItem) {
        binding.tvName.text = item.name
        binding.tvLastName.text = item.lastName
        binding.tvType.text = item.userType.name
    }

    override fun areItemsTheSame(oldItem: UserItem, newItem: UserItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UserItem, newItem: UserItem): Boolean {
        return oldItem == newItem
    }

}