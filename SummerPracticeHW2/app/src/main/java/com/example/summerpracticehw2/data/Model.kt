package com.example.summerpracticehw2.data
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Model(
    val imageResId: Int,
    val title: String,
    val description: String
) : Parcelable
