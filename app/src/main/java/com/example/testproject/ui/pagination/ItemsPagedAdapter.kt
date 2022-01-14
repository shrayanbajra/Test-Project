package com.example.testproject.ui.pagination

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.databinding.ItemPaginationBinding
import com.example.testproject.ui.pagination.dto.PicSumDto

class ItemsPagedAdapter :
    PagingDataAdapter<PicSumDto, ItemsPagedAdapter.PaginationViewHolder>(CharacterComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaginationViewHolder {

        val itemBinding = ItemPaginationBinding.inflate(
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

    class PaginationViewHolder(private val binding: ItemPaginationBinding)

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