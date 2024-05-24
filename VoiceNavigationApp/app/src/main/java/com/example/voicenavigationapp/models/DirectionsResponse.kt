package com.example.voicenavigationapp.models

data class DirectionsResponse(
    val routes: List<Route>
)

data class Route(
    val legs: List<Leg>
)

data class Leg(
    val steps: List<Step>
)

data class Step(
    val html_instructions: String,
    val distance: Distance
)

data class Distance(
    val text: String
)
