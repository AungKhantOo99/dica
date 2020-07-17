package com.ako.dica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.ako.dica.faqs.faq
import com.ako.dica.faqs.faqAda
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_faqs.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

class FaqsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faqs)
        supportActionBar?.title="Faqs"
        doAsync {
            //           http://128.199.112.232:4400/api/faqs
            //           https://dica-jad.herokuapp.com/api/faqs
            val json= URL("http://128.199.112.232:4400/api/faqs").readText()
            uiThread {
                Log.d("Req",json)
                val faqs = Gson().fromJson(json,Array<faq>::class.java).toList()
                //              toast("There are ${faqs.size}")
                val layoutManager= GridLayoutManager(this@FaqsActivity,1)
                faqrecycle.layoutManager=layoutManager
                val adapter = faqAda(this@FaqsActivity,faqs)
                faqrecycle.adapter=adapter
            }
        }
    }
}
