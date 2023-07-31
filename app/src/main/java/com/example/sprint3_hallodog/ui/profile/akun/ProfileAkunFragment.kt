package com.example.sprint3_hallodog.ui.profile.akun

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint3_hallodog.R
import com.example.sprint3_hallodog.model.dummy.ProfileMenuModel
import com.example.sprint3_hallodog.ui.profile.ProfileMenuAdapter

class ProfileAkunFragment : Fragment(), ProfileMenuAdapter.ItemAdapterCallback {

    private var menuArrayList : ArrayList<ProfileMenuModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_akun, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        initDataDummy()

        var adapter = ProfileMenuAdapter(menuArrayList, this)
        var layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(activity)
        view.findViewById<RecyclerView>(R.id.rvItemProfile).layoutManager = layoutManager
        view.findViewById<RecyclerView>(R.id.rvItemProfile).adapter = adapter

    }

    fun initDataDummy() {
        menuArrayList = ArrayList()
        menuArrayList.add(ProfileMenuModel("Edit Profile"))
        menuArrayList.add(ProfileMenuModel("Alamat Saya"))
        menuArrayList.add(ProfileMenuModel("Keamanan"))
        menuArrayList.add(ProfileMenuModel("Keluar"))
    }

    override fun onClick(v: View, data: ProfileMenuModel) {
        Toast.makeText(context, data.title, Toast.LENGTH_SHORT).show()
    }


}