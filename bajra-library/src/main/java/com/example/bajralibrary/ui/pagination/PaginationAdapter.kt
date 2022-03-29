package com.example.bajralibrary.ui.pagination


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bajralibrary.databinding.ItemPagination1Binding

class PaginationAdapter : RecyclerView.Adapter<PaginationAdapter.PaginationViewHolder>() {

    private val mDataName = arrayListOf<String>()

    fun setData(items: List<String>) {
        mDataName.clear()
        mDataName.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemCount() = mDataName.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaginationViewHolder {
        val itemBinding = ItemPagination1Binding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return PaginationViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: PaginationViewHolder, position: Int) {

        val currentItem = mDataName[position]
        holder.bind(currentItem)

    }

    class PaginationViewHolder(private val binding: ItemPagination1Binding)

        : RecyclerView.ViewHolder(binding.root) {

        fun bind(currentItemName: String) {

            binding.tvTitle.text = currentItemName

        }

    }

}