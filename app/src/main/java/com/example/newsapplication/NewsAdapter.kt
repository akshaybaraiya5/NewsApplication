package com.example.newsapplication

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class NewsAdapter(private val context: Context, private val NewsItems:List<Articles>):
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view:View = LayoutInflater.from(context).inflate(R.layout.news_list,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return NewsItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.newsTitle.text = NewsItems[position].title
        holder.newsInfo.text = NewsItems[position].author
        Picasso.get().load(NewsItems[position].urlToImage).into(holder.newsImage)
        holder.itemView.setOnClickListener {


            val intent = Intent(context,NewsInfo::class.java)
            intent.putExtra("url",NewsItems[position].url)
            context.startActivity(intent)

        }
    }



    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
       val newsImage:ImageView = itemView.findViewById(R.id.NewsImage)
       val newsTitle:TextView = itemView.findViewById(R.id.NewsHeadline)
       val newsInfo:TextView = itemView.findViewById(R.id.NewsInfo)


    }
}