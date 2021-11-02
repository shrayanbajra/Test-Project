package com.example.testproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.cardview.widget.CardView

class ExpandableCardFragment : Fragment() {

    companion object {

        @JvmStatic
        fun newInstance() = ExpandableCardFragment()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_expandable_card, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cvExpandableCard: CardView = view.findViewById(R.id.cv_expandable_card)
        val llExpansibleView: LinearLayout = view.findViewById(R.id.ll_expandable_view)

        cvExpandableCard.setOnClickListener {

            val isCardExpanded = llExpansibleView.visibility == View.VISIBLE
            if (isCardExpanded) {

                llExpansibleView.visibility = View.GONE

            } else {

                llExpansibleView.visibility = View.VISIBLE

            }

        }

    }

}