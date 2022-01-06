package com.example.testproject.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.testproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private val mBinding get() = binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding!!.root
        setContentView(view)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        mBinding.btnSingleExpansibleCard.setOnClickListener {
            val intent = ExpansibleCardsActivity.newIntent(
                packageContext = this,
                category = ExpansibleCardsActivity.SINGLE
            )
            startActivity(intent)
        }

        mBinding.btnMultipleExpansibleCards.setOnClickListener {
            val intent = ExpansibleCardsActivity.newIntent(
                packageContext = this,
                category = ExpansibleCardsActivity.MULTIPLE
            )
            startActivity(intent)
        }

        mBinding.btnPermissionX.setOnClickListener {
            val intent = RequestPermissionActivity.newIntent(packageContext = this)
            startActivity(intent)
        }

    }

}