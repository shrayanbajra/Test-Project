package com.example.testproject.ui


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.databinding.ItemFeatureBinding
import com.example.testproject.utils.SingleParamItemClickListener

class FeaturesAdapter(private val clickListener: SingleParamItemClickListener<Feature>)

    : RecyclerView.Adapter<FeaturesAdapter.FeatureViewHolder>() {

    private val mFeatures = arrayListOf<Feature>()

    fun setFeatures(features: Array<Feature>) {
        mFeatures.clear()
        mFeatures.addAll(features)
        notifyDataSetChanged()
    }

    override fun getItemCount() = mFeatures.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeatureViewHolder {
        val itemBinding = ItemFeatureBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return FeatureViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: FeatureViewHolder, position: Int) {

        val feature = mFeatures[position]
        holder.bind(feature)

    }

    inner class FeatureViewHolder(private val binding: ItemFeatureBinding)

        : RecyclerView.ViewHolder(binding.root) {

        fun bind(feature: Feature) {

            binding.tvTitle.text = feature.title

            itemView.setOnClickListener {

                clickListener.onItemClick(item = feature)

            }


        }

    }

}