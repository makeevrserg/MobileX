package com.makeevrserg.mobilex.presentation.list.adapters.sealed

import androidx.recyclerview.widget.DiffUtil
import com.makeevrserg.mobilex.presentation.list.models.SealedUser

object SealedDiffCallback : DiffUtil.ItemCallback<SealedUser>() {
    override fun areItemsTheSame(oldItem: SealedUser, newItem: SealedUser): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: SealedUser, newItem: SealedUser): Boolean {
        return oldItem == newItem
    }
}