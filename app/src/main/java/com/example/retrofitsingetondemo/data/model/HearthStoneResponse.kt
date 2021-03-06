package com.example.retrofitsingetondemo.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HearthStoneResponse(
    @SerializedName("classes")
    val classes: List<String>
) : Parcelable
