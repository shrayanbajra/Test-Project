package com.example.bajralibrary.ui.pagination

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.bajralibrary.databinding.ItemPagination1Binding
import com.example.bajralibrary.ui.pagination.dto.PicSumDto

class ItemsPagedAdapter :
    PagingDataAdapter<PicSumDto, ItemsPagedAdapter.PaginationViewHolder>(CharacterComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaginationViewHolder {

        val itemBinding = ItemPagination1Binding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return PaginationViewHolder(itemBinding)

    }

    override fun onBindViewHolder(holder: PaginationViewHolder, position: Int) {

        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }

    }

    class PaginationViewHolder(private val binding: ItemPagination1Binding)

        : RecyclerView.ViewHolder(binding.root) {

        fun bind(currentItemName: PicSumDto?) {

            binding.tvTitle.text = currentItemName?.author

        }

    }

    object CharacterComparator : DiffUtil.ItemCallback<PicSumDto>() {
        override fun areItemsTheSame(oldItem: PicSumDto, newItem: PicSumDto) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: PicSumDto, newItem: PicSumDto) =
            oldItem == newItem
    }

}