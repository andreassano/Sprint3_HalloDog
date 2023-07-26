package com.example.sprint3_hallodog.ui.keranjang

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.sprint3_hallodog.databinding.FragmentKeranjangBinding

class KeranjangFragment : Fragment() {

    private lateinit var binding : FragmentKeranjangBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentKeranjangBinding.inflate(inflater, container, false)
        return binding.root

    }

}