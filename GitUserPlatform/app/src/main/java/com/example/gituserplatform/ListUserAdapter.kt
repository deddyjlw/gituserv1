package com.example.gituserplatform

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import com.example.gituserplatform.databinding.ItemRowUserBinding

class ListUserAdapter(var listUser: List<ListUser>) : RecyclerView.Adapter<ListUserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemRowUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(listUser[position])
    }

    override fun getItemCount(): Int = listUser.size

    class ViewHolder(private val binding: ItemRowUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindItem(listUser: ListUser) {
            binding.apply {
                tvItemName.text = listUser.name
                tvItemUsername.text = listUser.location
                circleImg.setImageResource(listUser.avatar)

                circleImg.setOnClickListener {
                    val intent = Intent(
                        itemView.context, DetailUserAct::class.java
                    )
                    intent.putExtra(
                        DetailUserAct.DATA, listUser
                    )
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

}