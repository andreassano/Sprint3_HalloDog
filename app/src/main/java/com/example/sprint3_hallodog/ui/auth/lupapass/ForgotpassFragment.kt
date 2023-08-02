package com.example.sprint3_hallodog.ui.auth.lupapass

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.sprint3_hallodog.R
import com.example.sprint3_hallodog.databinding.FragmentForgotpassBinding
import com.example.sprint3_hallodog.ui.auth.AuthActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ForgotpassFragment : Fragment() {
    private lateinit var binding: FragmentForgotpassBinding

     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = FragmentForgotpassBinding.inflate(inflater, container,false)
         return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLupaPass.setOnClickListener {
            val username = binding.inputUsername.text.toString().trim()
            val password = binding.inputPassword.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                resetPassword(username, password)
            } else {
                // Tambahkan tindakan sesuai kebutuhan, misalnya menampilkan pesan error ke pengguna
            }
        }

        binding.btnRegister.setOnClickListener {
            val signup = Intent(activity, AuthActivity::class.java)
            signup.putExtra("page_request",2)
            startActivity(signup)
        }
    }

    private fun resetPassword(username: String, password: String) {
        val databaseRef = FirebaseDatabase.getInstance().getReference("user")

        databaseRef.orderByChild("username").equalTo(username).addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                        val user = FirebaseAuth.getInstance().currentUser
                        user?.updatePassword(password)?.addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Toast.makeText(requireContext(), "Password berhasil diubah", Toast.LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(requireContext(), "Gagal mengubah password", Toast.LENGTH_SHORT).show()
                            }
                        }
                } else {
                    Toast.makeText(requireContext(), "Username tidak terdaftar", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(requireContext(), "Gagal melakukan query database", Toast.LENGTH_SHORT).show()
            }
        })
    }

}