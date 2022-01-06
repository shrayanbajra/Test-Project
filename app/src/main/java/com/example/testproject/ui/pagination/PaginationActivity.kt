package com.example.testproject.ui.pagination

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testproject.databinding.FragmentPaginationBinding

class PaginationActivity : AppCompatActivity() {

    private var binding: FragmentPaginationBinding? = null
    private val mBinding get() = binding!!

    private val paginationAdapter by lazy { PaginationAdapter() }

    companion object {

        fun newIntent(packageContext: Context): Intent {

            return Intent(packageContext, PaginationActivity::class.java)

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentPaginationBinding.inflate(layoutInflater)
        val view = binding!!.root
        setContentView(view)

        mBinding.rvItems.apply {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            adapter = paginationAdapter
        }

        val items = listOf("String 1", "String 2", "String 3")
        paginationAdapter.setData(items = items)
    }

}