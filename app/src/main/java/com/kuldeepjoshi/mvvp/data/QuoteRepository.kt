package com.kuldeepjoshi.mvvp.data

class QuoteRepository private constructor(val quoteDao: FakeQuoteDao) {

    fun addQuote(quote: Quote){
        quoteDao.addQuote(quote)
    }

    fun getQuotes() = quoteDao.getQuotes()

    companion object {

        @Volatile
        var instance: QuoteRepository? = null

        fun getInstance(quoteDao: FakeQuoteDao) =
            instance ?: synchronized(this){
                instance ?: QuoteRepository(quoteDao).also { instance = it }
            }


    }

}