package com.example.inswap.ui.maggot

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MaggotFarm(
    val farmName: String,
    val address: String,
    val phoneNum: String
): Parcelable
