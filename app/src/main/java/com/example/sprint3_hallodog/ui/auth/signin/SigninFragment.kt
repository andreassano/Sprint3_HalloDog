package com.example.sprint3_hallodog.ui.auth.signin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.sprint3_hallodog.MainActivity
import com.example.sprint3_hallodog.R
import com.example.sprint3_hallodog.databinding.FragmentProfileBinding
import com.example.sprint3_hallodog.databinding.FragmentSigninBinding
import com.example.sprint3_hallodog.model.User
import com.example.sprint3_hallodog.ui.auth.AuthActivity
import com.example.sprint3_hallodog.ui.auth.lupapass.ForgotpassFragment
import com.example.sprint3_hallodog.ui.auth.signup.SignupFragment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class SigninFragment : Fragment() {
    lateinit var binding :FragmentSigninBinding

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
            val username = binding.inputUsername.text.toString()
            val password = binding.inputPassword.text.toString()

            if (password.isNullOrEmpty() && username.isNullOrEmpty()) {
                binding.editTextPassword.error = "Silahkan masukkan password anda"
                binding.editTextUsername.error = "Silahkan masukkan username anda"
                binding.inputUsername.requestFocus()
            }else if (password.isNullOrEmpty()) {
                binding.editTextPassword.error = "Silahkan masukkan password anda"
                binding.inputPassword.requestFocus()
            }else if (username.isNullOrEmpty()) {
                binding.editTextUsername.error = "Silahkan masukkan username anda"
                binding.inputUsername.requestFocus()
            }else{
                login()
            }

        }

        binding.btnLupaPass.setOnClickListener {
            val forgotPass = Intent(activity, AuthActivity::class.java)
            forgotPass.putExtra("page_request",3)
            startActivity(forgotPass)
        }

        binding.inputUsername.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.editTextUsername.error = null // Menghapus pesan error saat mulai mengetik
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        binding.inputPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.editTextPassword.error = null // Menghapus pesan error saat mulai mengetik
            }
            override fun afterTextChanged(s: Editable?) {}
        })

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
                            saveUserDataToSharedPreferences(userData)
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
                Toast.makeText(requireContext(), "Login gagal, Silakan coba lagi.", Toast.LENGTH_SHORT).show()
            }

        })

    }
    private fun saveUserDataToSharedPreferences(userData: User) {
        val sharedPref: SharedPreferences = requireActivity().getSharedPreferences("UserData", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("username", userData.username)
        editor.putString("name", userData.nama)
        editor.apply()
    }

}