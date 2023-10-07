package com.example.newsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var newsRecycler:RecyclerView = findViewById(R.id.NewsRecyclerView)
        var adapter:NewsAdapter;

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(newsinterface::class.java)


        val data = retrofitBuilder.getNews("in","general","9629737bc3bd4824af91243d66df7c36")
        data.enqueue(object : Callback<NewsList?> {
            override fun onResponse(call: Call<NewsList?>, response: Response<NewsList?>) {
                val dataList = response.body()
                val newsList = dataList!!.articles!!
                adapter = NewsAdapter(this@MainActivity,newsList)
                newsRecycler.layoutManager=LinearLayoutManager(this@MainActivity)
                newsRecycler.adapter = adapter

            }

            override fun onFailure(call: Call<NewsList?>, t: Throwable) {
                Toast.makeText(this@MainActivity,"abbe yaar",Toast.LENGTH_SHORT).show()
            }
        })


    }
}