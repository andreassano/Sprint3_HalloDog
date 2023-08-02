package com.example.sprint3_hallodog.ui.home.homebutton.konsultasi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint3_hallodog.databinding.CardKonsultasiVerticalBinding
import com.example.sprint3_hallodog.model.Konsultasi
import com.google.firebase.database.FirebaseDatabase

class HomeButtonKonsultasiAdapter (private val dataDokter : ArrayList<Konsultasi>) : RecyclerView.Adapter<HomeButtonKonsultasiAdapter.ViewHolder>() {

    class ViewHolder (val binding : CardKonsultasiVerticalBinding) : RecyclerView.ViewHolder(binding.root)
    private val databaseRef = FirebaseDatabase.getInstance().getReference("konsultasi")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = CardKonsultasiVerticalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataDokter.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvNama.text = dataDokter[position].nama_dokter
        holder.binding.tvSpecialist.text = dataDokter[position].specialist
        holder.binding.tvTanggal.text = dataDokter[position].tanggal_konsultasi
        holder.binding.tvJam.text = dataDokter[position].jam_konsultasi

    }

    fun setData(newData: ArrayList<Konsultasi>) {
        dataDokter.clear()
        dataDokter.addAll(newData)
        notifyDataSetChanged()
    }


}