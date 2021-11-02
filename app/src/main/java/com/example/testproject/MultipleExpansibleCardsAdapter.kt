package com.example.testproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class MultipleExpansibleCardsAdapter(

    private val clickListener: CardClickListener

) :
    RecyclerView.Adapter<MultipleExpansibleCardsAdapter.ExpansibleCardViewHolder>() {

    private val mDummyModels = arrayListOf<DummyModel>()

    fun setData(models: List<DummyModel>) {
        mDummyModels.clear()
        mDummyModels.addAll(models)
        notifyDataSetChanged()
    }

    fun updateItemAt(model: DummyModel, position: Int) {
        mDummyModels[position] = model
        notifyItemChanged(position)
    }

    override fun getItemCount() = mDummyModels.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpansibleCardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_expansible_card, parent, false)
        return ExpansibleCardViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExpansibleCardViewHolder, position: Int) {

        val model = mDummyModels[position]
        holder.bind(model, position)

    }

    inner class ExpansibleCardViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val cvExpansibleCardView: CardView = view.findViewById(R.id.cv_expansible_card_view)

        private val rlMainView: RelativeLayout = view.findViewById(R.id.rl_main_view)
        private val llDetailView: LinearLayout = view.findViewById(R.id.ll_detail_view)

        private val ivArrow: ImageView = view.findViewById(R.id.iv_arrow)

        private val tvTitle: TextView = view.findViewById(R.id.tv_title)
        private val tvSubtitle: TextView = view.findViewById(R.id.tv_subtitle)
        private val tvDescription: TextView = view.findViewById(R.id.tv_body_1)

        fun bind(model: DummyModel, position: Int) {

            tvTitle.text = model.title
            tvSubtitle.text = model.subtitle
            tvDescription.text = model.description

            if (model.isExpanded) {

                ivArrow.setImageResource(R.drawable.ic_keyboard_arrow_up)
                llDetailView.visibility = View.VISIBLE

            } else {

                ivArrow.setImageResource(R.drawable.ic_keyboard_arrow_down)
                llDetailView.visibility = View.GONE

            }

            rlMainView.setOnClickListener {
                clickListener.onCardClicked(model = model, position = position)
            }

        }

    }

    interface CardClickListener {

        fun onCardClicked(model: DummyModel, position: Int)

    }

}