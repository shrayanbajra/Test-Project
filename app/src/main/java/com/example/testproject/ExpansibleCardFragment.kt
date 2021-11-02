package com.example.testproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager

class ExpansibleCardFragment : Fragment() {

    companion object {

        @JvmStatic
        fun newInstance() = ExpansibleCardFragment()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_expansible_card, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cvExpansibleCardView: CardView = view.findViewById(R.id.cv_expansible_card_view)
        val rlMainView: RelativeLayout = view.findViewById(R.id.rl_main_view)
        val llDetailView: LinearLayout = view.findViewById(R.id.ll_detail_view)
        val ivArrow: ImageView = view.findViewById(R.id.iv_arrow)

        rlMainView.setOnClickListener {

            val isCardExpanded = llDetailView.visibility == View.VISIBLE
            if (isCardExpanded) {

                TransitionManager.beginDelayedTransition(cvExpansibleCardView, AutoTransition())
                llDetailView.visibility = View.GONE
                AnimationUtils.toggleArrow(view = ivArrow, isExpanded = true)

            } else {

                TransitionManager.beginDelayedTransition(cvExpansibleCardView, AutoTransition())
                llDetailView.visibility = View.VISIBLE
                AnimationUtils.toggleArrow(view = ivArrow, isExpanded = false)

            }

        }

    }

}