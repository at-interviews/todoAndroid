package com.example.uselesstodo

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import com.example.uselesstodo.databinding.ListItemBinding

class TodoViewHolder(
    parent: ViewGroup,
    val binding: ListItemBinding = ListItemBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false
    )
) : RecyclerView.ViewHolder(
    binding.root
) {

}