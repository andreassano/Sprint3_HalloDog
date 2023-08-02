package com.example.sprint3_hallodog.ui.home.homebutton.food

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sprint3_hallodog.R
import com.example.sprint3_hallodog.databinding.FragmentDetailFoodBinding

class DetailFoodFragment : Fragment() {
    private lateinit var binding: FragmentDetailFoodBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailFoodBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view:View,savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        val product = arguments?.getString("nama_product")
        val harga = arguments?.getString("harga")
        binding.tvProduct.text = product
        binding.tvHarga.text = harga
    }

}