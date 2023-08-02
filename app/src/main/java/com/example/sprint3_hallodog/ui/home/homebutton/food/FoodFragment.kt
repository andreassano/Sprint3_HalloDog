package com.example.sprint3_hallodog.ui.home.homebutton.food

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sprint3_hallodog.databinding.FragmentFoodBinding
import com.example.sprint3_hallodog.model.Food
import com.example.sprint3_hallodog.ui.home.homebutton.HomeButtonFoodAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class FoodFragment : Fragment() {
    private lateinit var binding: FragmentFoodBinding
    private lateinit var adapter: HomeButtonFoodAdapter
    private lateinit var databaseRef: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFoodBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = HomeButtonFoodAdapter(ArrayList())

        binding.rvFood.adapter = adapter
        binding.rvFood.layoutManager = GridLayoutManager(requireContext(), 2, LinearLayoutManager.VERTICAL, false)

        databaseRef = FirebaseDatabase.getInstance().getReference("food")
        databaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val foodList = ArrayList<Food>()
                for (snapshot in dataSnapshot.children) {
                    val food = snapshot.getValue(Food::class.java)
                    food?.let { foodList.add(it) }
                }
                adapter.setData(foodList)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle database error
            }
        })
    }

}