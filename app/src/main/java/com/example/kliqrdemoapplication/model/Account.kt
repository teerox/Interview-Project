package com.example.kliqrdemoapplication.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize



@Parcelize
data class Account(
    val id: Long,
    val image: String,
    val amount: String,
    val accountNumber: String,
    val bankName: String,
    val lastChecked: String,
    val active:Boolean

): Parcelable