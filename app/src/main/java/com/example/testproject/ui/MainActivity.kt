package com.example.testproject.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testproject.databinding.ActivityMainBinding
import com.example.testproject.exhaustive
import com.example.testproject.ui.pagination.PaginationActivity
import com.example.testproject.ui.sandwich.SandwichActivity
import com.example.testproject.utils.SingleParamItemClickListener

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private val mBinding get() = binding!!

    private val mAdapter by lazy { FeaturesAdapter(clickListener = clickListener) }

    private val clickListener
        get() = object : SingleParamItemClickListener<Feature> {

            override fun onItemClick(item: Feature) {

                when (item) {

                    Feature.SINGLE_EXPANSIBLE_CARD -> openSingleExpansibleCardActivity()

                    Feature.MULTIPLE_EXPANSIBLE_CARD -> openMultipleExpansibleCardsActivity()

                    Feature.PAGINATION -> openPaginationActivity()

                    Feature.IMAGE_CHOOSER -> openImageChooserActivity()

                    Feature.SANDWICH -> openSandwichActivity()

                    Feature.EQUAL_SPACING_RESPONSIVE_DESIGN -> openEqualSpacingResponsiveDesignActivity()

                }.exhaustive

            }

        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding!!.root
        setContentView(view)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        initRvFeatures()
        val features = Feature.values()
        mAdapter.setFeatures(features)

    }

    private fun openSingleExpansibleCardActivity() {
        val intent = ExpansibleCardsActivity.newIntent(
            packageContext = this,
            category = ExpansibleCardsActivity.SINGLE
        )
        startActivity(intent)
    }

    private fun openMultipleExpansibleCardsActivity() {
        val intent = ExpansibleCardsActivity.newIntent(
            packageContext = this,
            category = ExpansibleCardsActivity.MULTIPLE
        )
        startActivity(intent)
    }

    private fun openPaginationActivity() {
        val intent = PaginationActivity.newIntent(packageContext = this)
        startActivity(intent)
    }

    private fun openImageChooserActivity() {
        val intent = ImageChooserActivity.newIntent(packageContext = this)
        startActivity(intent)
    }

    private fun openSandwichActivity() {
        val intent = SandwichActivity.newIntent(packageContext = this)
        startActivity(intent)
    }

    private fun openEqualSpacingResponsiveDesignActivity() {
//        val intent = EqualSpacingResponsiveDesignActivity.newIntent(packageContext = this)
//        startActivity(intent)

        val intent = PaginationActivity.newIntent(packageContext = this)
        startActivity(intent)
    }

    private fun openPermissionXActivity() {
        val intent = RequestPermissionActivity.newIntent(packageContext = this)
        startActivity(intent)
    }

    private fun initRvFeatures() {
        mBinding.rvFeatures.apply {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            adapter = mAdapter
        }
    }

}