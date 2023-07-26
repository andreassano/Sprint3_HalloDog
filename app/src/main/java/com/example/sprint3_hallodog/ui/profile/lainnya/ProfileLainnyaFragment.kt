package com.example.sprint3_hallodog.ui.profile.lainnya

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint3_hallodog.R
import com.example.sprint3_hallodog.model.dummy.ProfileMenuModel
import com.example.sprint3_hallodog.ui.profile.ProfileMenuAdapter


class ProfileLainnyaFragment : Fragment() {

    private var menuArrayList : ArrayList<ProfileMenuModel> = ArrayList()

 override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_lainnya, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        initDataDummy()

        val adapter = ProfileMenuAdapter(menuArrayList, this)
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(activity)
        view.findViewById<RecyclerView>(R.id.rvItemProfile).layoutManager = layoutManager
        view.findViewById<RecyclerView>(R.id.rvItemProfile).adapter = adapter

    }

    fun initDataDummy() {
        menuArrayList = ArrayList()
        menuArrayList.add(ProfileMenuModel("Edit Profile"))
        menuArrayList.add(ProfileMenuModel("Alamat Saya"))
        menuArrayList.add(ProfileMenuModel("Keamanan"))
    }



}