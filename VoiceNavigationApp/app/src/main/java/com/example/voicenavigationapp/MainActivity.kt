package com.example.voicenavigationapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.voicenavigationapp.databinding.ActivityMainBinding
import com.example.voicenavigationapp.manager.VoiceRecognitionManager
import com.example.voicenavigationapp.utils.GeocodingHelper

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var voiceRecognitionManager: VoiceRecognitionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        voiceRecognitionManager = VoiceRecognitionManager(this) { address ->
            GeocodingHelper.getLatLngFromAddress(address) { lat, lng ->
                startNavigation(lat, lng)
            }
        }

        binding.startNavigationButton.setOnClickListener {
            voiceRecognitionManager.startListening()
        }
    }

    private fun startNavigation(lat: Double, lng: Double) {
        val intent = Intent(this, NavigationActivity::class.java).apply {
            putExtra("DEST_LAT", lat)
            putExtra("DEST_LNG", lng)
        }
        startActivity(intent)
    }
}
