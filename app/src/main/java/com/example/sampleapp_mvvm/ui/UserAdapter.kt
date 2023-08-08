package com.example.sampleapp_mvvm.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sampleapp_mvvm.data.model.UserDto
import com.example.sampleapp_mvvm.databinding.ListItemBinding
import com.example.sampleapp_mvvm.domain.User

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private val diffItemCallback = object : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }

    val listDiffer = AsyncListDiffer(this, diffItemCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(listDiffer.currentList[position])
    }

    override fun getItemCount(): Int {
        return listDiffer.currentList.size
    }

    inner class UserViewHolder(
        private val binding: ListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(userItem: User) {
            binding.apply {
                textName.text = userItem.name
                textEmail.text = userItem.email
                Glide.with(imageAvatar.context)
                    .load(userItem.imagePath)
                    .centerCrop()
                    .into(imageAvatar)
            }
        }
    }
}