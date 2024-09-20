package com.example.myintendtapp

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize //to simplefied

@Parcelize
// Intent Explicit dengan Parcelable
data class Person(
    val name: String?,
    val age: Int?,
    val email: String?,
    val city: String?,
): Parcelable


