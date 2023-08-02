package com.example.sprint3_hallodog.ui.home.homebutton.konsultasi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sprint3_hallodog.databinding.FragmentKonsultasiBinding
import com.example.sprint3_hallodog.model.Konsultasi
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class KonsultasiFragment : Fragment() {
    private lateinit var binding : FragmentKonsultasiBinding
    private lateinit var adapter: HomeButtonKonsultasiAdapter
    private lateinit var databaseRef: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentKonsultasiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = HomeButtonKonsultasiAdapter(ArrayList())
        binding.rvKonsultasi.adapter = adapter
        binding.rvKonsultasi.layoutManager = LinearLayoutManager(requireContext())

        databaseRef = FirebaseDatabase.getInstance().getReference("konsultasi")
        databaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val dokterList = ArrayList<Konsultasi>()
                for (snapshot in dataSnapshot.children) {
                    val konsultasi = snapshot.getValue(Konsultasi::class.java)
                    konsultasi?.let { dokterList.add(it) }
                }
                adapter.setData(dokterList)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle database error
            }
        })
    }



}