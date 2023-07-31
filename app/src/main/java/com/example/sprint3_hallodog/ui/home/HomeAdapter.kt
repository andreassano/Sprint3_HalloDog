package com.example.sprint3_hallodog.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sprint3_hallodog.R
import com.example.sprint3_hallodog.model.dummy.HomeButtonModel
import com.google.android.material.button.MaterialButton

class HomeAdapter (
    private val listdata : List<HomeButtonModel>,
    private val itemAdapterCallback: ItemAdapterCallback,
        ) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view =  layoutInflater.inflate(R.layout.item_home_horizontal, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeAdapter.ViewHolder, position: Int) {
        holder.bind(listdata[position], itemAdapterCallback)
    }

    override fun getItemCount(): Int {
        return listdata.size
    }

    class ViewHolder (itemView:View) : RecyclerView.ViewHolder(itemView) {

        private val btnMenu = itemView.findViewById<MaterialButton>(R.id.btnMenu)

        fun bind(data: HomeButtonModel, itemAdapterCallback: ItemAdapterCallback) {
            itemView.apply {
                btnMenu.text = data.title

                btnMenu.setIconResource(data.icon)

                itemView.setOnClickListener{
                    itemAdapterCallback.onClick(it, data)
                }
            }
        }
    }

    interface ItemAdapterCallback {
        fun onClick(v: View, data: HomeButtonModel)
    }
}