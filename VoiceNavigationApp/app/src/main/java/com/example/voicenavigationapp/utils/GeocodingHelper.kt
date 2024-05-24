package com.example.voicenavigationapp.utils

import com.example.voicenavigationapp.api.GeocodingApi
import com.example.voicenavigationapp.models.GeocodingResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object GeocodingHelper {
    fun getLatLngFromAddress(address: String, callback: (Double, Double) -> Unit) {
        val geocodingApi = RetrofitInstance.api

        geocodingApi.getGeocodingData(address, "AIzaSyB8ywbcpeQSlVVAPT9S_EDXIlA3_D5ozts").enqueue(object : Callback<GeocodingResponse> {
            override fun onResponse(call: Call<GeocodingResponse>, response: Response<GeocodingResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        val location = it.results[0].geometry.location
                        callback(location.lat, location.lng)
                    }
                }
            }

            override fun onFailure(call: Call<GeocodingResponse>, t: Throwable) {
                // Handle failure
            }
        })
    }
}
