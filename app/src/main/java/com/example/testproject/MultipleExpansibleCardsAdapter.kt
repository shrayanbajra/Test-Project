package com.example.testproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MultipleExpansibleCardsAdapter :
    RecyclerView.Adapter<MultipleExpansibleCardsAdapter.ExpansibleCardViewHolder>() {

    private val mDummyModels = arrayListOf<DummyModel>()

    fun setData(models: List<DummyModel>) {
        mDummyModels.clear()
        mDummyModels.addAll(models)
        notifyDataSetChanged()
    }

    override fun getItemCount() = mDummyModels.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpansibleCardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_expansible_card, parent, false)
        return ExpansibleCardViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExpansibleCardViewHolder, position: Int) {

        val model = mDummyModels[position]
        holder.bind(model)

    }

    class ExpansibleCardViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val tvTitle: TextView = view.findViewById(R.id.tv_title)
        private val tvSubtitle: TextView = view.findViewById(R.id.tv_subtitle)
        private val tvDescription: TextView = view.findViewById(R.id.tv_body_1)

        fun bind(model: DummyModel) {

            tvTitle.text = model.title
            tvSubtitle.text = model.subtitle
            tvDescription.text = model.description

        }

    }

}