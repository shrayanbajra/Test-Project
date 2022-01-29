package com.example.testproject.ui.sandwich

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testproject.databinding.ActivitySandwichBinding

class SandwichActivity : AppCompatActivity() {

    private var binding: ActivitySandwichBinding? = null
    private val mBinding get() = binding!!

    companion object {

        fun newIntent(packageContext: Context): Intent {

            return Intent(packageContext, SandwichActivity::class.java)

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySandwichBinding.inflate(layoutInflater)
        val view = binding!!.root
        setContentView(view)
    }

}