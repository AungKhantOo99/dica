package com.ako.dica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.ako.dica.contacts.company
import com.ako.dica.contacts.companyAdapter
import kotlinx.android.synthetic.main.activity_contacts.*
import kotlinx.android.synthetic.main.contact_bottomsheet.*

class ContactsActivity : AppCompatActivity() {
    var listOfCompany = ArrayList<company>()
    val displaylist = ArrayList<company>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)
        supportActionBar?.title="Contacts"
        listOfCompany.add(
            company(
                "Investment Division 1", "No1,Thitsar Road,Yankin Township,Yangon",
                "01658127", "01658136", "investment1,director.mic@gmail.com",
                "",16.784778,96.172223
            )
        )
        listOfCompany.add(
            company(
                "Investment Division 2", "No1,Thitsar Road,Yankin Township,Yangon",
                "01658128", "01658141", "mic.investment2@gmail.com",
                "",17.784778,96.172223
            )
        )
        listOfCompany.add(
            company(
                "Investment Division 3", "No1,Thitsar Road,Yankin Township,Yangon",
                "01658127", "01658136", "incthree@gmail.com",
                "",18.784778,96.172223
            )
        )
        listOfCompany.add(
            company(
                "Investment Division 4", "No1,Thitsar Road,Yankin Township,Yangon",
                "01658130", "01658142", "dica.investment4@gmail.com",
                "",19.784778,96.172223
            )
        )
        listOfCompany.add(
            company(
                "Policy and Legal Affairs Division", "No1,Thitsar Road,Yankin Township,Yangon",
                "01658131", "01658139", "director.pl.dica@mptmail.net.mm",
                "policy.legal.dica@gmail.com",16.784778,96.172223
            )
        )
        listOfCompany.add(
            company(
                "Investment Monitoring Division", "No1,Thitsar Road,Yankin Township,Yangon",
                "01658133", "01657824", "director.monitor.dica@mptmail.net.mm",
                "mic.dica.monitor@gmail.com",15.784778,96.172223
            )
        )
        listOfCompany.add(
            company(
                "Company Affairs Division", "No1,Thitsar Road,Yankin Township,Yangon",
                "01657891", "01658135", "director.company.dica@mptmail.net.mm",
                "",16.784778,97.172223
            )
        )
        listOfCompany.add(
            company(
                "Investment Promotion Division", "No1,Thitsar Road,Yankin Township,Yangon",
                "01658132", "01658143", "director.ip.dica@mptmail.net.mm",
                "dica.ip.mm@gmail.com",16.784778,93.172223
            )
        )
        listOfCompany.add(
            company(
                "Nay Pyi Taw Branch", "office No.32,Zayahtani Road,Nay OPyi Taw",
                "067406124", "067406166", "dica.npw@gmail.com",
                "",16.784778,99.172223
            )
        )
        listOfCompany.add(
            company(
                "Yangon Branch",
                "One Stop Services (OSS),Yangon Reagon Plot No.49,Myay Taing No.85/KanBae,Sein Lay May Lane," +
                        "Kabar Aye Road.Yakin Township,Yangon",
                "01658236", "01658264", "dicayangonregion@gmail.com",
                "",16.784778,96.172223
            )
        )
        listOfCompany.add(
            company(
                "Mandalay Branch",
                "Between 26*27 street,84 Street,North of Zaycho Buliding,Third Floor,Chanayetharzan Township,Mandalay",
                "024086661", "024086662", "dica.mdy@gmail.com",
                "",16.784778,96.172223
            )
        )
        listOfCompany.add(
            company(
                "Mawlamying Branch",
                "Compound of Mon State Goverment Office,Yone Gyi Street,Panpatan Ward,Mawlamying,Mon State",
                "0572023395", "0572023385",
                "dica.mawlamying11020142gmail.com",
                "",16.784778,96.172223
            )
        )
        displaylist.addAll(listOfCompany)
        val layoutManager= LinearLayoutManager(this)
        company.layoutManager=layoutManager
        val adapter= companyAdapter(this,displaylist,supportFragmentManager)
        company.adapter=adapter
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //  menuInflater.inflate(R.menu.menu,menu)
        //   val menuItem = menu!!.findItem(R.id.search)
        if(menuItem!= null){
            //    val searchView=menuItem.actionView as androidx.appcompat.widget.SearchView
            menuItem.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }
                override fun onQueryTextChange(newText: String?): Boolean {
                    if(newText!!.isNotEmpty()){
                        displaylist.clear()
                        val find=newText.toLowerCase()
                        listOfCompany.forEach {
                            if(it.Cname!!.toLowerCase().contains(find)){
                                displaylist.add(it)
                            }
                        }
                        company.adapter!!.notifyDataSetChanged()
                    }else{
                        displaylist.clear()
                        displaylist.addAll(listOfCompany)
                        company.adapter!!.notifyDataSetChanged()
                    }
                    return true
                }

            })
        }
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}

