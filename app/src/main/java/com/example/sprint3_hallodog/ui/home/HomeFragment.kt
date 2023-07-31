package com.example.sprint3_hallodog.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint3_hallodog.R
import com.example.sprint3_hallodog.databinding.FragmentHomeBinding
import com.example.sprint3_hallodog.model.dummy.HomeButtonModel
import com.example.sprint3_hallodog.model.dummy.HomeVerticalModel

class HomeFragment : Fragment(), HomeAdapter.ItemAdapterCallback {

    private var buttonlist : ArrayList<HomeButtonModel> = ArrayList()
    private lateinit var rvMenuVertical: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDataDummy()

        val adapter = HomeAdapter(buttonlist, this)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        view.findViewById<RecyclerView>(R.id.rvMenu).layoutManager = layoutManager
        view.findViewById<RecyclerView>(R.id.rvMenu).adapter = adapter

        rvMenuVertical = view.findViewById(R.id.rvMenuVertical)

        val verticalLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvMenuVertical.layoutManager = verticalLayoutManager

        val verticalData = initDataVerticalDummy()
        val verticalAdapter = HomeVerticalAdapter(verticalData)
        rvMenuVertical.adapter = verticalAdapter
    }

    fun initDataDummy(){
        buttonlist = ArrayList()
        buttonlist.add(HomeButtonModel("Konsultasi", R.drawable.konsultasi))
        buttonlist.add(HomeButtonModel("Pet Food", R.drawable.food))
        buttonlist.add(HomeButtonModel("Vitamin", R.drawable.vitamins))
        buttonlist.add(HomeButtonModel("Pet Shop", R.drawable.shop))

    }

    fun initDataVerticalDummy(): List<HomeVerticalModel> {
        val dataList = ArrayList<HomeVerticalModel>()
        dataList.add(HomeVerticalModel("Berikan cinta, perhatian, dan waktu berkualitas untuk hewan peliharaan Anda. Interaksi positif dengan pemiliknya dapat meningkatkan ikatan emosional dan membantu hewan peliharaan merasa lebih aman dan bahagia"))
        dataList.add(HomeVerticalModel("Berikan waktu untuk bermain dan berolahraga bersama hewan peliharaan Anda. Aktivitas fisik dan mental dapat membantu menjaga kesehatannya dan menghindari masalah perilaku"))
        dataList.add(HomeVerticalModel(" Lakukan pelatihan dasar untuk hewan peliharaan Anda agar patuh dan memiliki perilaku yang baik. Tetapi selalu lakukan dengan metode positif dan penuh kesabaran"))
        // Tambahkan data dummy sesuai dengan kebutuhan
        return dataList
    }

    override fun onClick(v: View, data: HomeButtonModel) {

    }

}