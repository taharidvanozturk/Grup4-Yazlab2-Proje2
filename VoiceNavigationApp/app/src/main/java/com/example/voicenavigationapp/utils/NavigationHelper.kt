package com.example.voicenavigationapp.utils

import com.example.voicenavigationapp.models.DirectionsResponse
import com.example.voicenavigationapp.api.DirectionsApi
import com.example.voicenavigationapp.utils.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object NavigationHelper {
    fun provideNavigationInstructions(startLat: Double, startLng: Double, endLat: Double, endLng: Double, callback: (String) -> Unit) {
        val directionsApi = RetrofitInstance.directionsApi
        val origin = "$startLat,$startLng"
        val destination = "$endLat,$endLng"

        directionsApi.getDirections(origin, destination, "walking", "AIzaSyB8ywbcpeQSlVVAPT9S_EDXIlA3_D5ozts").enqueue(object : Callback<DirectionsResponse> {
            override fun onResponse(call: Call<DirectionsResponse>, response: Response<DirectionsResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let { directionsResponse ->
                        val steps = directionsResponse.routes[0].legs[0].steps
                        val instructions = steps.joinToString(separator = "\n") { step ->
                            step.html_instructions.replace(Regex("<.*?>"), "") + " (" + step.distance.text + ")"
                        }
                        callback(instructions)
                    }
                }
            }

            override fun onFailure(call: Call<DirectionsResponse>, t: Throwable) {
                callback("Navigasyon talimatları alınırken bir hata oluştu: ${t.message}")
            }
        })
    }
}
