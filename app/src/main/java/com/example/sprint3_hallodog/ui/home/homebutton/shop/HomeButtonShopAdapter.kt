package com.example.sprint3_hallodog.ui.home.homebutton.shop

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint3_hallodog.databinding.CardShopVerticalBinding
import com.example.sprint3_hallodog.databinding.CardVitaminVerticalBinding
import com.example.sprint3_hallodog.model.Food
import com.example.sprint3_hallodog.model.Konsultasi
import com.example.sprint3_hallodog.model.Shop
import com.example.sprint3_hallodog.model.Vitamin
import com.google.firebase.database.FirebaseDatabase

class HomeButtonShopAdapter (
    private val dataShop: ArrayList<Shop>
    ) : RecyclerView.Adapter<HomeButtonShopAdapter.ViewHolder>() {

    class ViewHolder (val binding : CardShopVerticalBinding) : RecyclerView.ViewHolder(binding.root)
    private val databaseRef = FirebaseDatabase.getInstance().getReference("shop")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = CardShopVerticalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataShop.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val food = dataShop[position]

        holder.binding.tvNama.text = dataShop[position].nama_product
        holder.binding.tvHarga.text = dataShop[position].harga

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

    fun setData(newData: ArrayList<Shop>) {
        dataShop.clear()
        dataShop.addAll(newData)
        notifyDataSetChanged()
    }


}