package com.kuldeepjoshi.mvvp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeQuoteDao {

    //Fake table like in database.
    private val quoteList = mutableListOf<Quote>()

    //MutableLiveData is from architechture library. It will observe the live data changes.
    private val quotes = MutableLiveData<List<Quote>>()

    init{
        quotes.value = quoteList
    }

    /**
     * Following method will add data into the mutableList
     */
    fun addQuote(quote: Quote){
        quoteList.add(quote)
        quotes.value = quoteList
    }

    fun getQuotes() = quotes as LiveData<List<Quote>>
}