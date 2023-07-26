package com.example.sprint3_hallodog.ui.auth.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.sprint3_hallodog.databinding.FragmentSignupBinding
import com.example.sprint3_hallodog.model.User
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class SignupFragment : Fragment() {
    private lateinit var binding: FragmentSignupBinding
    private lateinit var databaseRef : DatabaseReference

   override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding = FragmentSignupBinding.inflate(inflater, container, false)
       return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        databaseRef = FirebaseDatabase.getInstance().getReference("user")
        binding.btnLogin.setOnClickListener {
            addData()
        }
    }

    private fun addData() {
        val nama = binding.inputNama.text.toString()
        val username = binding.inputUsername.text.toString()
        val password = binding.inputPassword.text.toString()

        val userID = databaseRef.push().key!!
        val userData = User(userID,nama, username, password)

        databaseRef.child(userID!!).setValue(userData).addOnCompleteListener{
            Toast.makeText(requireContext(), "Berhasil Mendaftar", Toast.LENGTH_SHORT).show()
            findNavController().navigateUp()
        }.addOnFailureListener {
            Toast.makeText(requireContext(), "Belum Berhasil Mendaftar, Silahkan Coba Lagi", Toast.LENGTH_SHORT).show()
        }

    }

}