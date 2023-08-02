package com.example.sprint3_hallodog.ui.home.homebutton

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint3_hallodog.R
import com.example.sprint3_hallodog.databinding.CardFoodVerticalBinding
import com.example.sprint3_hallodog.model.Food
import com.google.firebase.database.FirebaseDatabase

class HomeButtonFoodAdapter (
    private val dataFood: ArrayList<Food>
    ) : RecyclerView.Adapter<HomeButtonFoodAdapter.ViewHolder>() {

    class ViewHolder (val binding : CardFoodVerticalBinding) : RecyclerView.ViewHolder(binding.root)
    private val databaseRef = FirebaseDatabase.getInstance().getReference("food")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = CardFoodVerticalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataFood.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val food = dataFood[position]

        holder.binding.tvNama.text = dataFood[position].nama_product
        holder.binding.tvHarga.text = dataFood[position].harga

        /*holder.binding.cardFood.setOnClickListener{
            val bundle = Bundle()
            bundle.putString("nama_product", dataFood[position].nama_product)
            bundle.putString("harga", dataFood[position].harga)
            navController.navigate(R.id.action_foodFragment_to_detailFoodFragment, bundle)
        }
*/

/*
        food.imageUrl?.let {
            Glide.with(holder.itemView.context)
                .load(it)
                .placeholder(R.drawable.imgfood1) // Gambar placeholder sementara
                .error(R.drawable.imgfood1) // Gambar error jika terjadi kesalahan
                .into(holder.binding.imgFood)
        }
*/

    }

    fun setData(newData: ArrayList<Food>) {
        dataFood.clear()
        dataFood.addAll(newData)
        notifyDataSetChanged()
    }


}