package com.example.a4_recyclerviewcustomadapterloadingmorekotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a4_recyclerviewcustomadapterloadingmorekotlin.R
import com.example.a4_recyclerviewcustomadapterloadingmorekotlin.listner.OnBottomReachedListner
import com.example.a4_recyclerviewcustomadapterloadingmorekotlin.model.Member

class CustomAdapter(val members: List<Member>, val listner: OnBottomReachedListner) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_view, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position == members.size - 1){
            listner.onBottomListner(position)
        }

        val member = members.get(position)

        if (holder is CustomViewHolder){
            holder.tv_name.setText(member.tv_name)
            holder.tv_number.setText(member.tv_number)
        }
    }

    override fun getItemCount(): Int {
        return members.size
    }
    class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tv_name = view.findViewById<TextView>(R.id.tv_name_true)
        val tv_number = view.findViewById<TextView>(R.id.tv_tel_true)
    }
}


