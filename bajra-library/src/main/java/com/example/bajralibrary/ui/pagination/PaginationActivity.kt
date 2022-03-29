package com.example.bajralibrary.ui.pagination

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bajralibrary.databinding.FragmentPagination1Binding
import com.example.bajralibrary.extensions.showShortToast
import com.example.testproject.network.NetworkResult
import kotlinx.coroutines.flow.collectLatest

class PaginationActivity : AppCompatActivity() {

    private var binding: FragmentPagination1Binding? = null
    private val mBinding get() = binding!!

    companion object {

        private const val TAG = "PaginationActivity"

        fun newIntent(packageContext: Context): Intent {

            return Intent(packageContext, PaginationActivity::class.java)

        }

    }

    private val mPaginationAdapter by lazy { PaginationAdapter() }
    private val mPagedAdapter by lazy {
        ItemsPagedAdapter().apply {
            withLoadStateHeaderAndFooter(
                header = ItemLoadingStateAdapter(this),
                footer = ItemLoadingStateAdapter(this)
            )
        }
    }

    private val mViewModel by lazy { ViewModelProvider(this)[PaginationViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentPagination1Binding.inflate(layoutInflater)
        val view = binding!!.root
        setContentView(view)

        mBinding.rvItems.apply {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            adapter = mPagedAdapter
        }

        val items = listOf("String 1", "String 2", "String 3")
        mPaginationAdapter.setData(items = items)

        lifecycleScope.launchWhenCreated {
            mViewModel.items.collectLatest { pagingData ->
                mPagedAdapter.submitData(pagingData)
            }
        }

        mViewModel.getList().observe(this) { networkResult ->

            when (networkResult) {

                is NetworkResult.Loading -> {

                    showShortToast(message = "Loading")
                    Log.d(TAG, "onCreate: Loading")

                }

                is NetworkResult.Error -> {

                    val errorMessage = networkResult.message ?: "Something went wrong"
                    showShortToast(message = errorMessage)
                    Log.d(TAG, "onCreate: $errorMessage")

                }

                is NetworkResult.Success -> {

                    showShortToast("Success")
                    Log.d("PaginationActivity", "onCreate: ${networkResult.data}")

                }

            }

        }

    }

}