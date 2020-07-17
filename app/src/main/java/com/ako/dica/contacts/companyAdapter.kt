package com.ako.dica.contacts

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.ako.dica.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.contact_bottomsheet.view.*
import kotlinx.android.synthetic.main.contact_companylist.view.*
lateinit var googleMap: GoogleMap
class companyAdapter(val context: Context,val company:ArrayList<company>,val supportFragmentManager: FragmentManager) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view= LayoutInflater.from(context).inflate(R.layout.contact_companylist,parent,false)
        return ViewHolder(view)
    }
    class ViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView)

    override fun getItemCount(): Int {
        return company.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val arrayget = company[position]
        holder.itemView.Cname.text=arrayget.Cname
        holder.itemView.Caddress.text=arrayget.Caddress
        if(position==0){
            holder.itemView.listtitle.visibility=View.VISIBLE
            holder.itemView.listtitle.setText("DICA Head office")
        }else if(position==7){
            holder.itemView.listtitle.visibility=View.VISIBLE
            holder.itemView.listtitle.setText("Branch and office")
        }
        holder.itemView.showdetail.setOnClickListener{
            val get = company[position]
            var con: Context? = null
            val dialog = BottomSheetDialog(context)
            val inflator = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val itemView = inflator.inflate(R.layout.contact_bottomsheet, null)
            itemView.address.text=get.Caddress
            itemView.firstph.text=get.Cfph
            itemView.secondph.text=get.Csph
            itemView.firstemail.text=get.Cfemail
            itemView.secondemail.text=get.Csemail

            val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
            mapFragment.getMapAsync(OnMapReadyCallback {
                googleMap = it
                val location = LatLng(get.CLat!!,get.CLong!!)
                googleMap.addMarker(MarkerOptions().position(location).title("Hello"))
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location,15f))
            })
            itemView.callfirst.setOnClickListener {
                val int=Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+get.Cfph))
                startActivity(context,int,null)
            }
            if(get.Csph!!.isEmpty()){
                itemView.callsecond.visibility=View.GONE
                itemView.secondph.visibility=View.GONE
                itemView.secphicon.visibility=View.GONE
            }else{
                itemView.callsecond.setOnClickListener {
                    val int = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + get.Csph))
                    ContextCompat.startActivity(context, int, null)
                }
            }
            dialog.setContentView(itemView)
            dialog.show()
        }
    }
}