package com.example.newsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient

class NewsInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_info)
        val web: WebView = findViewById(R.id.webView)
        val url: String? = intent.getStringExtra("url")
        if(url!=null){
            web.settings.javaScriptEnabled = true
            web.webViewClient= object:WebViewClient(){
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    web.visibility = View.VISIBLE
                }
            }
            web.loadUrl(url)

        }

    }
}