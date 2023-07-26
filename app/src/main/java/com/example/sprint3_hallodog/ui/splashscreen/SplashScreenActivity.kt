package com.example.sprint3_hallodog.ui.splashscreen

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import com.example.sprint3_hallodog.R
import com.example.sprint3_hallodog.databinding.ActivitySplashScreenBinding
import com.example.sprint3_hallodog.ui.auth.AuthActivity


class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySplashScreenBinding
    private lateinit var topAnim : Animation
    private lateinit var botAnim : Animation
    private lateinit var image : ImageView
    private lateinit var textTop : TextView
    private lateinit var textBot : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, AuthActivity::class.java))
        }, 2000)

        //Animasi
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        botAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        //set Animasi ke objek
        image = findViewById(R.id.imageHaloDog)
        textTop = findViewById(R.id.tvHaloDog)
        textBot = findViewById(R.id.tvTakeCare)

        image.startAnimation(topAnim)
        textTop.startAnimation(botAnim)
        textBot.startAnimation(botAnim)

    }
}