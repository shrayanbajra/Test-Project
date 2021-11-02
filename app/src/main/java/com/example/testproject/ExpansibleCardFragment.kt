package com.example.testproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout

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

        val rlMainView: RelativeLayout = view.findViewById(R.id.rl_main_view)
        val llDetailView: LinearLayout = view.findViewById(R.id.ll_detail_view)
        val ivArrow: ImageView = view.findViewById(R.id.iv_arrow)

        rlMainView.setOnClickListener {

            val isCardExpanded = llDetailView.visibility == View.VISIBLE
            if (isCardExpanded) {

                AnimationUtils.collapse(view = llDetailView)
                AnimationUtils.toggleArrow(view = ivArrow, isExpanded = true)

            } else {

                AnimationUtils.expand(view = llDetailView)
                AnimationUtils.toggleArrow(view = ivArrow, isExpanded = false)

            }

        }

    }

}