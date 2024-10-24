package com.example.homeworkfromezis

import java.io.Serializable

data class CarModel(
    val img: String,
    val model: String,
    val number: String,
    val price: Int,
    val description: String
): Serializable
