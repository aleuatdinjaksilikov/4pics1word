package com.example.a4pics1word

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.a4pics1word.databinding.ActivityRegisterBinding
import com.example.a4pics1word.entity.QuestionList
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class RegisterActivity : AppCompatActivity() {
    lateinit var mAdView : AdView
    lateinit var binding: ActivityRegisterBinding
    lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferences = getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE)

        val currentIndex = preferences.getInt("currentIndex",0)
        Log.d("Logcat",currentIndex.toString())
        val coins = preferences.getInt("Coins",0)
        val levelIndex = preferences.getInt("LevelIndex",0)

        binding.tvCoinsRegister.text = coins.toString()

        binding.tvLevelRegister.text = "${QuestionList.getQuestion()[currentIndex].id + levelIndex * QuestionList.getQuestion().size}"

        val question = QuestionList.getQuestion()[currentIndex]
        binding.img1Register.setImageResource(question.images[0])
        binding.img2Register.setImageResource(question.images[1])
        binding.img3Register.setImageResource(question.images[2])
        binding.img4Register.setImageResource(question.images[3])

        mAdView = binding.adView
        MobileAds.initialize(this){}

        binding.btnPlay.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("currentIndex",currentIndex)
            intent.putExtra("Coins",coins)
            intent.putExtra("LevelIndex",levelIndex)
            startActivity(intent)
        }

        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        binding.btnSettings.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        preferences = getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE)

        val currentIndex = preferences.getInt("currentIndex",0)
        val coins = preferences.getInt("Coins",0)
        val levelIndex = preferences.getInt("LevelIndex",0)
        binding.tvCoinsRegister.text = coins.toString()

        binding.tvLevelRegister.text = "${QuestionList.getQuestion()[currentIndex].id + levelIndex * QuestionList.getQuestion().size}"

        val question = QuestionList.getQuestion()[currentIndex]
        binding.img1Register.setImageResource(question.images[0])
        binding.img2Register.setImageResource(question.images[1])
        binding.img3Register.setImageResource(question.images[2])
        binding.img4Register.setImageResource(question.images[3])
    }
}