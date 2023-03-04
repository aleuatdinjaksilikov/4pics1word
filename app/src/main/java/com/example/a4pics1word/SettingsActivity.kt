package com.example.a4pics1word

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a4pics1word.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {

    lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBackSettings.setOnClickListener {
            finish()
        }


    }
}