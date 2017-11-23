package com.blanke.livedataviewmodeldemo

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.blanke.livedataviewmodeldemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBing: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBing = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainBing.viewModal = ViewModelProviders.of(this).get(NewsViewModel::class.java)
        with(mainBing.viewModal) {
            this!!.news.observe(this@MainActivity, Observer<News> {
                if (it == null) return@Observer
                with(mainBing) {
                    title.text = it.title
                    content.text = it.content
                }
            })
        }
    }
}
