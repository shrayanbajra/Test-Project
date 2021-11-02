package com.example.testproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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

    private val mAdapter: MultipleExpansibleCardsAdapter by lazy {
        MultipleExpansibleCardsAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvExpansibleCards: RecyclerView = view.findViewById(R.id.rv_expansible_cards)

        val items = getDummyData()
        mAdapter.setData(items)

        initRvExpansibleCards(rvExpansibleCards)

    }

    private fun initRvExpansibleCards(rvExpansibleCards: RecyclerView) {
        rvExpansibleCards.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = mAdapter
        }
    }

    private fun getDummyData(): List<DummyModel> {

        val items = arrayListOf<DummyModel>()

        for (i in 1..20) {

            val item = DummyModel(
                title = "Title $i", subtitle = "Subtitle $i", description = "Description $i"
            )

            items.add(item)

        }

        return items
    }

}