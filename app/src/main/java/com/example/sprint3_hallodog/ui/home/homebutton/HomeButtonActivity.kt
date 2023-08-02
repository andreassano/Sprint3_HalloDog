package com.example.sprint3_hallodog.ui.home.homebutton

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.sprint3_hallodog.MainActivity
import com.example.sprint3_hallodog.R
import com.example.sprint3_hallodog.ui.auth.signup.SignupFragment
import com.example.sprint3_hallodog.ui.home.homebutton.food.FoodFragment
import com.example.sprint3_hallodog.ui.home.homebutton.konsultasi.KonsultasiFragment
import com.example.sprint3_hallodog.ui.home.homebutton.shop.ShopFragment
import com.example.sprint3_hallodog.ui.home.homebutton.vitamin.VitaminFragment

class HomeButtonActivity : AppCompatActivity() {
    private lateinit var toolbar : Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_button)

        toolbar = findViewById(R.id.toolbar)

        val pageRequest = intent.getIntExtra("page_request", 1)

        if (pageRequest == 1) {
            toolbarKonsultasi()
            // Memanggil fragment "Sign Up"
            val konsultasiFragment = KonsultasiFragment()

            // Mengganti tampilan fragment pada container di activity_auth.xml
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, konsultasiFragment)
                .commit()
        }

        if (pageRequest == 2) {
            toolbarPetFood()
            // Memanggil fragment "Sign Up"
            val petfoodFragment = FoodFragment()

            // Mengganti tampilan fragment pada container di activity_auth.xml
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, petfoodFragment)
                .commit()
        }

        if (pageRequest == 3) {
            toolbarVitamin()
            // Memanggil fragment "Sign Up"
            val vitaminFragment = VitaminFragment()

            // Mengganti tampilan fragment pada container di activity_auth.xml
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, vitaminFragment)
                .commit()
        }

        if (pageRequest == 4) {
            toolbarPetShop()
            // Memanggil fragment "Sign Up"
            val petshopFragment = ShopFragment()

            // Mengganti tampilan fragment pada container di activity_auth.xml
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, petshopFragment)
                .commit()
        }
    }

    private fun toolbarKonsultasi() {
        toolbar.navigationIcon = resources.getDrawable(R.drawable.baseline_arrow_back, null)
        toolbar.setNavigationOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        val textView = toolbar.findViewById<TextView>(R.id.tvToolbar)
        textView.text = "Konsultasi"
    }

    private fun toolbarPetFood() {
        toolbar.navigationIcon = resources.getDrawable(R.drawable.baseline_arrow_back, null)
        toolbar.setNavigationOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        val textView = toolbar.findViewById<TextView>(R.id.tvToolbar)
        textView.text = "Pet Food"
    }

    private fun toolbarVitamin() {
        toolbar.navigationIcon = resources.getDrawable(R.drawable.baseline_arrow_back, null)
        toolbar.setNavigationOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        val textView = toolbar.findViewById<TextView>(R.id.tvToolbar)
        textView.text = "Vitamin"
    }

    private fun toolbarPetShop() {
        toolbar.navigationIcon = resources.getDrawable(R.drawable.baseline_arrow_back, null)
        toolbar.setNavigationOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        val textView = toolbar.findViewById<TextView>(R.id.tvToolbar)
        textView.text = "Pet Shop"
    }

}