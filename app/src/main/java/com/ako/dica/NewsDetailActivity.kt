package com.ako.dica

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import com.ako.dica.news.new
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_news_detail.*

class NewsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)
        val showdetail=intent.getParcelableExtra<new>("key")
        newsdetailtitle.text=showdetail.title
        Picasso.get().load("http://128.199.112.232:4400/"+showdetail?.newsImage).into(newsdetailimage)
        newsdetailbody.text=
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) Html.fromHtml((showdetail?.body),
                Html.FROM_HTML_MODE_COMPACT)
            else Html.fromHtml(showdetail.body)
        val ary:List<String> = showdetail.createdAt.split("T")
        newsdetaildate.text=ary[0]
    }
}