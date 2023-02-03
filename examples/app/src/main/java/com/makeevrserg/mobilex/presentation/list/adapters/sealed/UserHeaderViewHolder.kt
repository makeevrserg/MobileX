package com.makeevrserg.mobilex.presentation.list.adapters.sealed

import com.makeevrserg.mobilex.databinding.ItemHeaderBinding
import com.makeevrserg.mobilex.presentation.list.models.SealedUser
import com.makeevrserg.mobilex.rvadapter.sealed.SealedViewBinder


class UserHeaderViewHolder : SealedViewBinder<SealedUser, SealedUser.Header, ItemHeaderBinding>(
    SealedUser.Header::class.java,
    ItemHeaderBinding::inflate
) {
    override val viewType: Int = 1

    override fun bind(binding: ItemHeaderBinding, item: SealedUser.Header) {
        binding.tv.text = item.userType.name
    }
}