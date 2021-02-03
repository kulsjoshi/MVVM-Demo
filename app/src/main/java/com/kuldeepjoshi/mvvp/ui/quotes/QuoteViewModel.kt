package com.kuldeepjoshi.mvvp.ui.quotes

import androidx.lifecycle.ViewModel
import com.kuldeepjoshi.mvvp.data.Quote
import com.kuldeepjoshi.mvvp.data.QuoteRepository

class QuoteViewModel(val quoteRepository: QuoteRepository) : ViewModel() {

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
    fun getQuotes() = quoteRepository.getQuotes()

}