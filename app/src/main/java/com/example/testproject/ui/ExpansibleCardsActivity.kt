package com.example.testproject.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testproject.R
import com.example.testproject.ui.multiple_expansible_cards.MultipleExpansibleCardsFragment
import com.example.testproject.ui.single_expansible_card.SingleExpansibleCardFragment

class ExpansibleCardsActivity : AppCompatActivity() {

    companion object {

        private const val ARGUMENT = "argument"

        const val SINGLE = "single"
        const val MULTIPLE = "multiple"

        fun newIntent(packageContext: Context, category: String): Intent {

            val intent = Intent(packageContext, ExpansibleCardsActivity::class.java)
            intent.putExtra(ARGUMENT, category)
            return intent

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expansible_cards)

        val category = intent.getStringExtra(ARGUMENT)
        val fragment = when (category) {
            SINGLE -> {

                SingleExpansibleCardFragment.newInstance()

            }
            MULTIPLE -> {

                MultipleExpansibleCardsFragment.newInstance()

            }
            else -> {

                SingleExpansibleCardFragment.newInstance()

            }
        }

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, fragment, fragment.tag)
            .commit()

    }

}