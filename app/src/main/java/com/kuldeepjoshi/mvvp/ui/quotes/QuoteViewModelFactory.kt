package com.kuldeepjoshi.mvvp.ui.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kuldeepjoshi.mvvp.data.QuoteRepository

class QuoteViewModelFactory(private val quoteRepository: QuoteRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return  QuoteViewModel(quoteRepository) as T
    }

}