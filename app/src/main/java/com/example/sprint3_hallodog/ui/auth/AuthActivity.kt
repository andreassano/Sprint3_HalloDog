package com.example.sprint3_hallodog.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.sprint3_hallodog.R
import com.example.sprint3_hallodog.ui.auth.lupapass.ForgotpassFragment
import com.example.sprint3_hallodog.ui.auth.signup.SignupFragment

class AuthActivity : AppCompatActivity() {
    private lateinit var toolbar : Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        toolbar = findViewById(R.id.toolbar)

        val pageRequest = intent.getIntExtra("page_request", 1)

        if (pageRequest == 2) {
            toolbarSignUp()
            // Memanggil fragment "Sign Up"
            val signUpFragment = SignupFragment()

            // Mengganti tampilan fragment pada container di activity_auth.xml
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, signUpFragment)
                .commit()
        }
        if (pageRequest == 3) {
            toolbarForgotPass()
            // Memanggil fragment "Sign Up"
            val forgotPass = ForgotpassFragment()

            // Mengganti tampilan fragment pada container di activity_auth.xml
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, forgotPass)
                .commit()
        }

    }

        private fun toolbarSignUp() {
            toolbar.navigationIcon = resources.getDrawable(R.drawable.baseline_arrow_back, null)
            toolbar.setNavigationOnClickListener {
                onBackPressedDispatcher.onBackPressed()
            }
            val textView = toolbar.findViewById<TextView>(R.id.tvToolbar)
            textView.text = "Daftar"
        }
        private fun toolbarForgotPass() {
            toolbar.navigationIcon = resources.getDrawable(R.drawable.baseline_arrow_back, null)
            toolbar.setNavigationOnClickListener {
                onBackPressedDispatcher.onBackPressed()
            }
            val textView = toolbar.findViewById<TextView>(R.id.tvToolbar)
            textView.text = "Lupa Password"
        }

}