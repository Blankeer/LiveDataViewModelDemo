package com.blanke.livedataviewmodeldemo

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableBoolean

/**
 * Created by blanke on 2017/11/22.
 */

class NewsViewModel(application: Application) : AndroidViewModel(application) {
    val news: MutableLiveData<News> = MutableLiveData()
    private val newsRepo: NewsRepo = NewsRepo()
    val loading = ObservableBoolean(false)

    fun loadData() {
        loading.set(true)
        newsRepo.loadData(object : NewsRepo.Call {
            override fun onLoadData(news: News) {
                loading.set(false)
                this@NewsViewModel.news.value = news
            }
        })
    }
}
