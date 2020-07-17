package com.ako.dica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_contacts.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.contact_bottomsheet.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
    //    val bottomSheetBehavior = BottomSheetBehavior.from(layoutBottomSheet)
//       val bottomSheetBehavior=BottomSheetBehavior.from(layoutBottomSheet)
//        Investment.setOnClickListener {
//            if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_COLLAPSED) {
//                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
//            } else {
//                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
//            }
//        }
        News.setOnClickListener {
            startActivity(Intent(this,NewsActivity::class.java))
        }
        Faqs.setOnClickListener {
            startActivity(Intent(this,FaqsActivity::class.java))
        }
        Contact.setOnClickListener {
            startActivity(Intent(this,ContactsActivity::class.java))
        }
        Investment.setOnClickListener {
            startActivity(Intent(this,com.ako.dica.Investment::class.java))
        }
    }
}
