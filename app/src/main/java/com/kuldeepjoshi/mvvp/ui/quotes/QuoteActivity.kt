package com.kuldeepjoshi.mvvp.ui.quotes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.kuldeepjoshi.mvvp.R
import com.kuldeepjoshi.mvvp.data.Quote
import com.kuldeepjoshi.mvvp.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_main.*

class QuoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialization()
    }

    private fun initialization() {

        val quoteViewModelFactory = InjectorUtils.provideQuotesViewModelFactory()

        val viewModel = ViewModelProviders.of(this, quoteViewModelFactory).get(
            QuoteViewModel::class.java
        )

        viewModel.getQuotes().observe(this, Observer { quoteList ->
            val stringBuilder = StringBuilder()

            quoteList.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }

            textView_quotes.text = stringBuilder.toString()

        })

        button_add_quote.setOnClickListener {

            val quote = Quote(
                editText_quote.text.toString(),
                editText_author.text.toString()
            )

            viewModel.addQuote(quote)

            editText_author.setText("")
            editText_quote.setText("")

        }

    }

}