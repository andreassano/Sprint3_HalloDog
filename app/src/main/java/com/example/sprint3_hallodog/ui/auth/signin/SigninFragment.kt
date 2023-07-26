package com.example.sprint3_hallodog.ui.auth.signin

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.sprint3_hallodog.MainActivity
import com.example.sprint3_hallodog.R
import com.example.sprint3_hallodog.databinding.FragmentSigninBinding
import com.example.sprint3_hallodog.model.User
import com.example.sprint3_hallodog.ui.auth.AuthActivity
import com.example.sprint3_hallodog.ui.auth.signup.SignupFragment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class SigninFragment : Fragment() {
    private lateinit var binding :FragmentSigninBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSigninBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegister.setOnClickListener {
            val signup = Intent(activity, AuthActivity::class.java)
            signup.putExtra("page_request",2)
            startActivity(signup)
        }

        binding.btnLogin.setOnClickListener {
            login()
        }

    }

    private fun login() {
        val username = binding.inputUsername.text.toString()
        val password = binding.inputPassword.text.toString()

        // Mendapatkan referensi ke database user
        val databaseRef = FirebaseDatabase.getInstance().getReference("user")

        // Mengeksekusi query untuk mencari data user dengan username yang sesuai
        databaseRef.orderByChild("username").equalTo(username).addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var loginSuccess = false // Menyimpan status login berhasil atau tidak

                if (dataSnapshot.exists()) {

                    for (snapshot in dataSnapshot.children) {
                        val userData = snapshot.getValue(User::class.java)

                        if (userData?.password == password) {
                            // Login berhasil, lakukan aksi sesuai kebutuhan
                            Toast.makeText(requireContext(), "Login berhasil", Toast.LENGTH_SHORT).show()
                            val home = Intent(activity, MainActivity::class.java)
                            startActivity(home)
                            activity?.finish()

                            loginSuccess = true // Set status login berhasil
                            break // Keluar dari loop jika login berhasil
                        }

                    }

                }

                if (!loginSuccess) {
                    // Login gagal, username atau password salah
                    Toast.makeText(requireContext(), "Username atau password salah", Toast.LENGTH_SHORT).show()
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(requireContext(), "Login gagal. Silakan coba lagi.", Toast.LENGTH_SHORT).show()
            }

        })

    }

}