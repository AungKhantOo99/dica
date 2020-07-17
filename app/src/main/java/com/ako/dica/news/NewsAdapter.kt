package com.ako.dica.news

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ako.dica.NewsDetailActivity
import com.ako.dica.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.news_newslist.view.*

class NewsAdapter(val context: Context, val newlist:List<new>): RecyclerView.Adapter<NewsAdapter.ViewHolder>(){
    class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(context).inflate(R.layout.news_newslist,parent,false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return newlist.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val getapi=newlist[position]
        holder.itemView.title.text=getapi.title
        Picasso.get().load("http://128.199.112.232:4400/"+getapi.newsImage).into(holder.itemView.image)
        val ary:List<String> = getapi.createdAt.split("T")
        holder.itemView.date.text= ary[0]
 //       Picasso.get().load(getapi.newsImage).into(holder.itemView.image)
//        holder.itemView.newsdetailtitle.text=getapi.title
//        Picasso.get().load("https://dica-jad.herokuapp.com/"+getapi.newsImage).into(holder.itemView.newsdetailimage)
//        holder.itemView.newsdetailbody.text=getapi.body
//        holder.itemView.newsdetaildate.text=getapi.createdAt
        holder.itemView.showdetail.setOnClickListener {
            val intent= Intent(context,NewsDetailActivity::class.java)
            intent.putExtra("key",getapi)
            context.startActivity(intent)
        }
    }

}