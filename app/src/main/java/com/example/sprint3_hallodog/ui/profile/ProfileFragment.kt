package com.example.sprint3_hallodog.ui.profile

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.sprint3_hallodog.R
import com.example.sprint3_hallodog.databinding.FragmentProfileBinding
import com.example.sprint3_hallodog.model.User
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProfileFragment : Fragment() {
    private lateinit var binding : FragmentProfileBinding
    private var userId: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = getUserDataFromSharedPreferences("name")
        val username = getUserDataFromSharedPreferences("username")
        binding.tvNama.text = name
        binding.tvEmail.text = username

        val sectionPagerAdapter = SectionPagerAdapter(
            childFragmentManager,
            binding.tabLayout
        )
        binding.viewPager.adapter = sectionPagerAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }

    private fun getUserDataFromSharedPreferences(key: String): String {
        val sharedPref: SharedPreferences = requireActivity().getSharedPreferences("UserData", Context.MODE_PRIVATE)
        return sharedPref.getString(key,"") ?: ""
    }

}