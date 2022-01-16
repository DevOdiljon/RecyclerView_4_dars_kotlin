package com.example.a4_recyclerviewcustomadapterloadingmorekotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.example.a4_recyclerviewcustomadapterloadingmorekotlin.R
import com.example.a4_recyclerviewcustomadapterloadingmorekotlin.adapter.CustomAdapter
import com.example.a4_recyclerviewcustomadapterloadingmorekotlin.listner.OnBottomReachedListner
import com.example.a4_recyclerviewcustomadapterloadingmorekotlin.model.Member
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        val members = prepareMemberList()
        refreshAdapter(members)
    }

    private fun refreshAdapter(members: List<Member>) {
        val adapter = CustomAdapter(members, object: OnBottomReachedListner{
            override fun onBottomListner(position: Int) {
                Log.d("@@@", "jkhfe" + position)
            }
        })
        recyclerView.adapter = adapter

    }

    private fun prepareMemberList(): List<Member> {
        val members = ArrayList<Member>()
        for (i in 0..30 step 1){
            members.add(Member("Odilbek $i", "+998 97 775 17 79"))
        }
        return members
    }

    fun initViews(){
        recyclerView.layoutManager = GridLayoutManager(this, 1)
    }
}