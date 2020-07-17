package com.ako.dica.faqs

import android.content.Context
import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ako.dica.R
import kotlinx.android.synthetic.main.faqslist.view.*

class faqAda(val context: Context, val faqs : List<faq>) : RecyclerView.Adapter<faqAda.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(context).inflate(R.layout.faqslist,parent,false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return faqs.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val faq=faqs[position]
        holder.itemView.que.text=
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) Html.fromHtml((faq.question),
                Html.FROM_HTML_MODE_COMPACT)
            else Html.fromHtml(faq.question)
        holder.itemView.ans.text=
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) Html.fromHtml((faq.answer),
                Html.FROM_HTML_MODE_COMPACT)
            else Html.fromHtml(faq.answer)
//        holder.itemView.showans.setOnClickListener {
//            holder.itemView.showans.visibility= View.GONE
//            holder.itemView.closeans.visibility= View.VISIBLE
//
//        }
//        holder.itemView.closeans.setOnClickListener {
//            holder.itemView.showans.visibility= View.VISIBLE
//            holder.itemView.closeans.visibility= View.GONE
//            holder.itemView.ans.visibility= View.GONE
//        }
        holder.itemView.que.setOnClickListener {
            if(holder.itemView.arrowdown.visibility==View.VISIBLE)
                holder.itemView.arrowdown.visibility=View.GONE
                else
                if(holder.itemView.arrowdown.visibility==View.GONE)
                    holder.itemView.arrowdown.visibility=View.VISIBLE

            if(holder.itemView.arrowup.visibility==View.GONE)
                holder.itemView.arrowup.visibility=View.VISIBLE
            else
                if(holder.itemView.arrowup.visibility==View.VISIBLE)
                    holder.itemView.arrowup.visibility=View.GONE

            if(holder.itemView.ans.visibility==View.GONE)
                holder.itemView.ans.visibility=View.VISIBLE
            else
                if(holder.itemView.ans.visibility==View.VISIBLE)
                    holder.itemView.ans.visibility=View.GONE
        }
    }
    class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView)
}