package com.blanke.livedataviewmodeldemo

import android.os.Handler
import java.util.*

/**
 * Created by blanke on 2017/11/23.
 */
class NewsRepo {
    interface Call {
        fun onLoadData(news: News)
    }

    fun loadData(call: Call) {
        Handler().postDelayed({
            val random = Random()
            val news = News("title" + random.nextInt(999), "content" + random.nextInt(999))
            call.onLoadData(news)
        }, 1000)
    }
}
