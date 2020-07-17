package com.ako.dica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.UiThread
import androidx.recyclerview.widget.LinearLayoutManager
import com.ako.dica.news.NewsAdapter
import com.ako.dica.news.new
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_news.*

import org.jetbrains.anko.custom.async
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread
import java.net.URI
import java.net.URL

class NewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        supportActionBar?.title="News"
//            https://jsonplaceholder.typicode.com/albums
//            https://dica-jad.herokuapp.com/api/faqs
//        doAsync {
//            //           http://128.199.112.232:4400/api/faqs
//            //           https://dica-jad.herokuapp.com/api/faqs
//            val json=URL("https://dica-jad.herokuapp.com/api/news").readText()
//            uiThread {
//                Log.d("Req",json)
//              }
//          }
        refleshnews.setOnRefreshListener {
            refleshnews.isRefreshing=false
            doAsync {
                val getdate= URL("http://128.199.112.232:4400/api/news/").readText()
                uiThread {
                    val newslist = Gson().fromJson(getdate,Array<new>::class.java).toList()
                    Log.d("my_message",getdate)
                    val layoutManager= LinearLayoutManager(this@NewsActivity)
                    recnews.layoutManager=layoutManager
                    val adapter = NewsAdapter(this@NewsActivity,newslist)
                    recnews.adapter=adapter
                }
            }

        }
        doAsync {
            val getdate= URL("http://128.199.112.232:4400/api/news/").readText()
            uiThread {
                val newslist = Gson().fromJson(getdate,Array<new>::class.java).toList()
                Log.d("my_message",getdate)
                val layoutManager= LinearLayoutManager(this@NewsActivity)
                recnews.layoutManager=layoutManager
                val adapter = NewsAdapter(this@NewsActivity,newslist)
                recnews.adapter=adapter
            }
        }
        }
    }

