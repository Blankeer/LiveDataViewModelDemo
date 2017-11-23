package com.blanke.livedataviewmodeldemo

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.ObservableBoolean
import android.databinding.ObservableField

/**
 * Created by blanke on 2017/11/22.
 */

class NewsViewModel(application: Application) : AndroidViewModel(application) {
    private val newsRepo: NewsRepo = NewsRepo()
    val loading = ObservableBoolean(false)
    val news = ObservableField<News>()

    fun loadData() {
        loading.set(true)
        newsRepo.loadData(object : NewsRepo.Call {
            override fun onLoadData(news: News) {
                loading.set(false)
                this@NewsViewModel.news.set(news)
            }
        })
    }
}
