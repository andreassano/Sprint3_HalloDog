package com.example.sprint3_hallodog.ui.home.homebutton.shop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sprint3_hallodog.R
import com.example.sprint3_hallodog.databinding.FragmentKonsultasiBinding
import com.example.sprint3_hallodog.databinding.FragmentShopBinding
import com.example.sprint3_hallodog.databinding.FragmentVitaminBinding
import com.example.sprint3_hallodog.model.Food
import com.example.sprint3_hallodog.model.Shop
import com.example.sprint3_hallodog.ui.home.homebutton.HomeButtonFoodAdapter
import com.example.sprint3_hallodog.ui.home.homebutton.vitamin.HomeButtonVitaminAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ShopFragment : Fragment() {
    private lateinit var binding: FragmentShopBinding
    private lateinit var adapter: HomeButtonShopAdapter
    private lateinit var databaseRef: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentShopBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = HomeButtonShopAdapter(ArrayList())

        binding.rvShop.adapter = adapter
        binding.rvShop.layoutManager = GridLayoutManager(requireContext(), 2, LinearLayoutManager.VERTICAL, false)

        databaseRef = FirebaseDatabase.getInstance().getReference("shop")
        databaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val shopList = ArrayList<Shop>()
                for (snapshot in dataSnapshot.children) {
                    val shop = snapshot.getValue(Shop::class.java)
                    shop?.let { shopList.add(it) }
                }
                adapter.setData(shopList)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle database error
            }
        })
    }

}