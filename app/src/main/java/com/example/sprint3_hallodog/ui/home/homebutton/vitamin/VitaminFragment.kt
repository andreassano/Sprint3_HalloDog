package com.example.sprint3_hallodog.ui.home.homebutton.vitamin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sprint3_hallodog.databinding.FragmentVitaminBinding
import com.example.sprint3_hallodog.model.Vitamin
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class VitaminFragment : Fragment() {
    private lateinit var binding: FragmentVitaminBinding
    private lateinit var adapter: HomeButtonVitaminAdapter
    private lateinit var databaseRef: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentVitaminBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = HomeButtonVitaminAdapter(ArrayList())

        binding.rvVitamin.adapter = adapter
        binding.rvVitamin.layoutManager = GridLayoutManager(requireContext(), 2, LinearLayoutManager.VERTICAL, false)

        databaseRef = FirebaseDatabase.getInstance().getReference("vitamin")
        databaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val vitaminList = ArrayList<Vitamin>()
                for (snapshot in dataSnapshot.children) {
                    val vitamin = snapshot.getValue(Vitamin::class.java)
                    vitamin?.let { vitaminList.add(it) }
                }
                adapter.setData(vitaminList)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle database error
            }
        })
    }

}