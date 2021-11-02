package com.example.testproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


class MultipleExpansibleCardsFragment : Fragment() {

    companion object {

        @JvmStatic
        fun newInstance() = MultipleExpansibleCardsFragment()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_multiple_expansible_cards, container, false)
    }

}