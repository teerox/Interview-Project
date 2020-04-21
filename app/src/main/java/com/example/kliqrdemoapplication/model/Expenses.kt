package com.example.kliqrdemoapplication.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Expenses(
    val id: Int,
    val amountSpent: Long
): Parcelable