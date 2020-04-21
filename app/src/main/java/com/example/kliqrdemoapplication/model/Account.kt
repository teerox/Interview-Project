package com.example.kliqrdemoapplication.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize



@Parcelize
data class Account(
    val id: Int,
    val image: Int,
    val amount: Long,
    val accountNumber: String,
    val bankName: String,
    val lastChecked: String,
    var active:Boolean

): Parcelable