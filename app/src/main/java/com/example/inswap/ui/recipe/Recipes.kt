package com.example.inswap.ui.recipe

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


// Placeholder for dummy data
@Parcelize
data class Recipes(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable
