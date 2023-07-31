package com.example.sprint3_hallodog.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint3_hallodog.R
import com.example.sprint3_hallodog.model.dummy.HomeVerticalModel
import com.google.android.material.textview.MaterialTextView

class HomeVerticalAdapter (
    private val listdata : List<HomeVerticalModel>,
) : RecyclerView.Adapter<HomeVerticalAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view =  layoutInflater.inflate(R.layout.item_home_vertical, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listdata.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listdata[position])
    }

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvTitle = itemView.findViewById<MaterialTextView>(R.id.tvTitleTips)
        private val cvTips = itemView.findViewById<CardView>(R.id.cvTips)

        fun bind(data: HomeVerticalModel) {
            tvTitle.text = data.title
        }
    }
}