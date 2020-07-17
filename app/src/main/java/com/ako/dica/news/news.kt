package com.ako.dica.news

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class new (val id:Int,
                val title:String,
                val body:String,
                val newsImage:String,
                val createdAt:String,
                val updatedAt:String) : Parcelable