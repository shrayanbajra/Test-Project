package com.example.testproject.ui.sandwich

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.testproject.databinding.ActivitySandwichBinding
import com.example.testproject.showShortToast

class SandwichActivity : AppCompatActivity() {

    private var binding: ActivitySandwichBinding? = null
    private val mBinding get() = binding!!

    companion object {

        fun newIntent(packageContext: Context): Intent {

            return Intent(packageContext, SandwichActivity::class.java)

        }

    }

    private val mViewModel by lazy { ViewModelProvider(this)[SandwichViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySandwichBinding.inflate(layoutInflater)
        val view = binding!!.root
        setContentView(view)

        mViewModel.getPictures().observe(this) { response ->

            showShortToast(response)
            Log.d("SandwichActivity", response)

        }

    }

}