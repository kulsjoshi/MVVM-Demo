package com.kuldeepjoshi.mvvp.utilities

import com.kuldeepjoshi.mvvp.data.FakeDatabase
import com.kuldeepjoshi.mvvp.data.FakeQuoteDao
import com.kuldeepjoshi.mvvp.data.Quote
import com.kuldeepjoshi.mvvp.data.QuoteRepository
import com.kuldeepjoshi.mvvp.ui.quotes.QuoteViewModelFactory

object InjectorUtils {

    fun provideQuotesViewModelFactory(): QuoteViewModelFactory{
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuoteViewModelFactory(quoteRepository)
    }

}