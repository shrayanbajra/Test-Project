package com.example.testproject.ui.equal_spacing_responsive_design

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testproject.databinding.ActivityEqualSpacingResponsiveDesignBinding

class EqualSpacingResponsiveDesignActivity : AppCompatActivity() {

    private var binding: ActivityEqualSpacingResponsiveDesignBinding? = null
    private val mBinding get() = binding!!

    companion object {

        fun newIntent(packageContext: Context): Intent {

            return Intent(packageContext, EqualSpacingResponsiveDesignActivity::class.java)

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEqualSpacingResponsiveDesignBinding.inflate(layoutInflater)
        val view = binding!!.root
        setContentView(view)

        mBinding.apply {
            tvText1.text = "Brancher"
            tvText2.text = "Piece"
            tvText3.text = "Scanner"
            tvText4.text = "Wi-Fi"
            tvText5.text = "Synchronizer"
        }

    }

}