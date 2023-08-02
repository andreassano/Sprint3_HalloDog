package com.example.sprint3_hallodog.ui.home.homebutton.vitamin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint3_hallodog.databinding.CardVitaminVerticalBinding
import com.example.sprint3_hallodog.model.Food
import com.example.sprint3_hallodog.model.Konsultasi
import com.example.sprint3_hallodog.model.Vitamin
import com.google.firebase.database.FirebaseDatabase

class HomeButtonVitaminAdapter (
    private val dataVitamin: ArrayList<Vitamin>
    ) : RecyclerView.Adapter<HomeButtonVitaminAdapter.ViewHolder>() {

    class ViewHolder (val binding : CardVitaminVerticalBinding) : RecyclerView.ViewHolder(binding.root)
    private val databaseRef = FirebaseDatabase.getInstance().getReference("vitamin")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = CardVitaminVerticalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataVitamin.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val food = dataVitamin[position]

        holder.binding.tvNama.text = dataVitamin[position].nama_product
        holder.binding.tvHarga.text = dataVitamin[position].harga

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

    fun setData(newData: ArrayList<Vitamin>) {
        dataVitamin.clear()
        dataVitamin.addAll(newData)
        notifyDataSetChanged()
    }


}