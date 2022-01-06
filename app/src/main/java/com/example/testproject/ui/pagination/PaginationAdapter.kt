package com.example.testproject.ui.pagination


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.databinding.ItemPaginationBinding

class PaginationAdapter : RecyclerView.Adapter<PaginationAdapter.PaginationViewHolder>() {

    private val mDataName = arrayListOf<String>()

    fun setData(items: List<String>) {
        mDataName.clear()
        mDataName.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemCount() = mDataName.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaginationViewHolder {
        val itemBinding = ItemPaginationBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return PaginationViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: PaginationViewHolder, position: Int) {

        val currentItem = mDataName[position]
        holder.bind(currentItem)

    }

    class PaginationViewHolder(private val binding: ItemPaginationBinding)

        : RecyclerView.ViewHolder(binding.root) {

        fun bind(currentItemName: String) {

            binding.tvTitle.text = currentItemName

        }

    }

}