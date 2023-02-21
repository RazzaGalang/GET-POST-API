package com.example.getpostapi.mvvm.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.getpostapi.databinding.ItemRecyclerViewBinding
import com.example.getpostapi.mvvm.data.model.Data

class ActivityAdapter : RecyclerView.Adapter<ActivityAdapter.ViewHolder>() {

    inner class ViewHolder (private val binding: ItemRecyclerViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setData(item: Data) {
            binding.apply {
                val valuesID = item.id.toString()
                val valuesUsername = item.username
                val valuesFullname = item.fullName
                val valuesEmail = item.email
                val valuesCreated = item.createdAt
                val valuesUpdated = item.updatedAt

                tvID.text = valuesID
                tvUsername.text = valuesUsername
                tvFullName.text = valuesFullname
                tvEmail.text = valuesEmail
                tvCreated.text = valuesCreated
                tvUpdated.text = valuesUpdated


            }
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(
            oldItem: Data,
            newItem: Data
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: Data,
            newItem: Data
        ) = oldItem == newItem
    }

    private val differ = AsyncListDiffer(this, differCallback)

    var items : List<Data>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemRecyclerViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(items[position])
        holder.setIsRecyclable(true)
    }

    override fun getItemCount(): Int = items.size
}