package com.example.sprint3_hallodog.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint3_hallodog.MainActivity
import com.example.sprint3_hallodog.R
import com.example.sprint3_hallodog.databinding.FragmentHomeBinding
import com.example.sprint3_hallodog.model.dummy.HomeButtonModel
import com.example.sprint3_hallodog.model.dummy.HomeVerticalModel
import com.example.sprint3_hallodog.ui.auth.AuthActivity
import com.example.sprint3_hallodog.ui.home.homebutton.HomeButtonActivity
import com.example.sprint3_hallodog.ui.profile.ProfileFragment

class HomeFragment : Fragment(), HomeAdapter.ItemAdapterCallback {
    private lateinit var binding : FragmentHomeBinding
//    private var buttonlist : ArrayList<HomeButtonModel> = ArrayList()
    private lateinit var rvMenuVertical: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnKonsultasi.setOnClickListener {
            val konsultasi = Intent(activity, HomeButtonActivity::class.java)
            konsultasi.putExtra("page_request",1)
            startActivity(konsultasi)
        }

        binding.btnPetFood.setOnClickListener {
            val petfood = Intent(activity, HomeButtonActivity::class.java)
            petfood.putExtra("page_request",2)
            startActivity(petfood)
        }

        binding.btnVitamin.setOnClickListener {
            val vitamin = Intent(activity, HomeButtonActivity::class.java)
            vitamin.putExtra("page_request",3)
            startActivity(vitamin)
        }

        binding.btnPetShop.setOnClickListener {
            val petshop = Intent(activity, HomeButtonActivity::class.java)
            petshop.putExtra("page_request",4)
            startActivity(petshop)
        }

        /*binding.imgProfile.setOnClickListener {
            val profilePicture = Intent(activity, ProfileFragment::class.java)
            startActivity(profilePicture)
        }*/

        /*initDataDummy()

        val adapter = HomeAdapter(buttonlist, this)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        view.findViewById<RecyclerView>(R.id.rvMenu).layoutManager = layoutManager
        view.findViewById<RecyclerView>(R.id.rvMenu).adapter = adapter*/

        rvMenuVertical = view.findViewById(R.id.rvMenuVertical)

        val verticalLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvMenuVertical.layoutManager = verticalLayoutManager

        val verticalData = initDataVerticalDummy()
        val verticalAdapter = HomeVerticalAdapter(verticalData)
        rvMenuVertical.adapter = verticalAdapter
    }

    /*fun initDataDummy(){
        buttonlist = ArrayList()
        buttonlist.add(HomeButtonModel("Konsultasi", R.drawable.konsultasi))
        buttonlist.add(HomeButtonModel("Pet Food", R.drawable.food))
        buttonlist.add(HomeButtonModel("Vitamin", R.drawable.vitamins))
        buttonlist.add(HomeButtonModel("Pet Shop", R.drawable.shop))

    }*/

    fun initDataVerticalDummy(): List<HomeVerticalModel> {
        val dataList = ArrayList<HomeVerticalModel>()
        dataList.add(HomeVerticalModel("Berikan cinta, dan perhatian untuk hewan peliharaan Kamu", R.drawable.imgtips1, "01 Agustus, 2023"))
        dataList.add(HomeVerticalModel("Berikan waktu, dan berolahraga bersama hewan peliharaan Kamu" , R.drawable.imgtips2, "10 Januari, 2021"))
        dataList.add(HomeVerticalModel("Lakukan pelatihan dasar untuk hewan peliharaan Kamu", R.drawable.imgtips3, "17 November, 2017"))
        dataList.add(HomeVerticalModel("Jaga berat badan hewan peliharaan Anda agar tetap ideal", R.drawable.imgtips4, "23 Juni, 2010"))
        return dataList
    }

    override fun onClick(v: View, data: HomeButtonModel) {

    }
}